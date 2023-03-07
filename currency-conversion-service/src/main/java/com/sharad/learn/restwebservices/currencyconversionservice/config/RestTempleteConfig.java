/**
 * 
 */
package com.sharad.learn.restwebservices.currencyconversionservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author XY57013
 *
 */
@Configuration
public class RestTempleteConfig {

	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
