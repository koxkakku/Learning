/**
 * 
 */
package com.sharad.learn.restwebservices.limitsservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.learn.restwebservices.limitsservice.PropertyConfiguration;
import com.sharad.learn.restwebservices.limitsservice.bean.LimitConfiguration;

/**
 * @author XY57013
 *
 */
@RestController
public class LimitsConfigurationController {

	@Autowired
	private PropertyConfiguration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimits() {
		return new LimitConfiguration(1,1000);
		
	}
	
	@GetMapping("/limits-config")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(config.getMinimum(),config.getMaximum());
		
	}
	
}
