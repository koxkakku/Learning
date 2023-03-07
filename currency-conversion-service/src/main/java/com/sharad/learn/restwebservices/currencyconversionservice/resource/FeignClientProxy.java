/**
 * 
 */
package com.sharad.learn.restwebservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sharad.learn.restwebservices.currencyconversionservice.rbean.CurrencyConversionBean;

/**
 * @author XY57013
 *
 */
//@FeignClient(name = "currency-exchange", url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")//look for eureka server for the currency-exchange service//load balancing by feign
public interface FeignClientProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) ;
}
