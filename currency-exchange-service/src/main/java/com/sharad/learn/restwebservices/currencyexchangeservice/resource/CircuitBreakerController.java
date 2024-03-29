/**
 * 
 */
package com.sharad.learn.restwebservices.currencyexchangeservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author koxkakku
 *
 */
@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "default")//default retry 3 times
	public String getSampleApi() {
		logger.info("request received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api-url", String.class);
		//return "Sample API";
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-retry")
	@Retry(name = "sample-api-retry")//custom retry attemps config in application prop
	public String getSampleApiCustomRetry() {
		logger.info("========sample-api-retry request received======");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api-url", String.class);
		//return "Sample API";
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-retry-fallback")
	@Retry(name = "sample-api-retry-fallback" , fallbackMethod="hardCodedResponse")//custom retry attemps config in application prop
	public String getSampleApiCustomRetryFallBack() {
		logger.info("========sample-api-retry-fallback request received======");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api-url", String.class);
		//return "Sample API";
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-rate-limiter")
	@RateLimiter(name = "sample-api-retry-fallback")
	public String getSampleApiCustomRateLimiter() {
		logger.info("========sample-api-rate-Limiter-fallback request received======");
	return "Sample API";
	}
	@GetMapping("/sample-api-circuit-breaker")
	@CircuitBreaker(name = "sample-api-retry-fallback" , fallbackMethod="hardCodedResponse")
	@Bulkhead(name = "sample-api-retry-fallback",fallbackMethod="hardCodedResponse")
	public String getSampleApiCustomCircuitBreaker() {
		logger.info("========sample-api-circuit-breaker-fallback request received======");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api-url", String.class);
		//return "Sample API";
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-bulk-head")
	@Bulkhead(name = "sample-api-retry-fallback",fallbackMethod="hardCodedResponse")
	public String getSampleApiCustomBulkHead() {
		logger.info("========sample-api-bulk-head-fallback request received======");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api-url", String.class);
		//return "Sample API";
		return forEntity.getBody();
	}
	private String hardCodedResponse(Exception e) {
		return "hardCoded fallback response";
	}

}
