/**
 * 
 */
package com.sharad.learn.restwebservices.basic.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author koxkakku
 *
 */
@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean staticFiltering() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> staticFilteringList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"), 
			new SomeBean("value4","value5","value6"));
	}
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue dynamicFiltering() {
		SomeBeanDynamic someBean = new SomeBeanDynamic("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue dynamicFilteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"), 
			new SomeBean("value4","value5","value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
}
