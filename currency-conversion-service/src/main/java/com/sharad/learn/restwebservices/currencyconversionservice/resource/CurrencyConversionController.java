/**
 * 
 */
package com.sharad.learn.restwebservices.currencyconversionservice.resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sharad.learn.restwebservices.currencyconversionservice.rbean.CurrencyConversionBean;

/**
 * @author koxkakku
 *
 */
@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private FeignClientProxy proxy;
	
	@Autowired
	private RestTemplate restTemplete;
	
	@GetMapping("/currency-conversion-dummy/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyDummy(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		BigDecimal multiple = BigDecimal.valueOf(82.83D);
		return new CurrencyConversionBean(1L, from, to, quantity, multiple, quantity.multiply(multiple), 0);
	}
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		  Map<String,String> uriVariables = new HashMap<>(); 
		  uriVariables.put("from",
		  from); uriVariables.put("to", to);
		CurrencyConversionBean currencyConversionBean = null;
		CurrencyConversionBean body;
		ResponseEntity<CurrencyConversionBean> currencyExchangeResponseEntity = restTemplete.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class, 
				uriVariables );
		if( null!=currencyExchangeResponseEntity.getBody()) {
			body = currencyExchangeResponseEntity.getBody();
			currencyConversionBean = new CurrencyConversionBean(body.getId(),from, to, quantity, body.getConversionMultiple(),quantity.multiply(body.getConversionMultiple()), body.getPort());
		}
		return currencyConversionBean;
	}
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyfeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		logger.info("convertCurrencyfeign : from {} to {} for {} quantity", from,to,quantity);
		CurrencyConversionBean currencyConversionBean = null;
		CurrencyConversionBean currencyExchangeResponseEntity = proxy.retrieveExchangeValue(from, to);
		if( null!=currencyExchangeResponseEntity) {
			currencyConversionBean = new CurrencyConversionBean(currencyExchangeResponseEntity.getId(),from, to, quantity, currencyExchangeResponseEntity.getConversionMultiple(),quantity.multiply(currencyExchangeResponseEntity.getConversionMultiple()), currencyExchangeResponseEntity.getPort());
		}
		return currencyConversionBean;
	}
}
