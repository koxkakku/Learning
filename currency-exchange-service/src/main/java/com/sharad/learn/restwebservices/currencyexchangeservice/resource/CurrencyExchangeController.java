/**
 * 
 */
package com.sharad.learn.restwebservices.currencyexchangeservice.resource;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.learn.restwebservices.currencyexchangeservice.bean.ExchangeValue;
import com.sharad.learn.restwebservices.currencyexchangeservice.repo.ExchangeValueRepo;

/**
 * @author XY57013
 *
 */
@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepo repo;

	@GetMapping("/currency-exchange-dummy/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValueDummy(@PathVariable String from, @PathVariable String to) {
		
		return new ExchangeValue(1L, from, to, BigDecimal.valueOf(82.83D));
	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info("retrieveExchangeValue : from {} to {}", from,to);
		ExchangeValue exchangeValue = repo.findByFromAndTo(from,to);
		if(null==exchangeValue)
			throw new RuntimeException(String.format("Exchange value not found for %s to %s",from,to));
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
}
