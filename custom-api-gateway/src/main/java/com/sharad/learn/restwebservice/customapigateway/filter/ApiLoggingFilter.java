/**
 * 
 */
package com.sharad.learn.restwebservice.customapigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @author koxkakku
 *
 */
@Component
public class ApiLoggingFilter implements GlobalFilter{
	Logger logger = LoggerFactory.getLogger(ApiLoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of incoming request -> {}"+exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
