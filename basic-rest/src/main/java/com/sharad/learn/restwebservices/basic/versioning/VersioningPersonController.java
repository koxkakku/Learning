/**
 * 
 */
package com.sharad.learn.restwebservices.basic.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author koxkakku
 *
 */
@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Sharad Kumar Dutta");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Sharad", "Kumar", "Dutta"));
	}
	
	@GetMapping(path = "/person", params = "version=1" )
	public PersonV1 getFirstVersionOfPersonRequestParam() {
		return new PersonV1("Sharad Kumar Dutta");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		return new PersonV2(new Name("Sharad", "Kumar", "Dutta"));
	}
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1" )
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Sharad Kumar Dutta");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2" )
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Sharad", "Kumar", "Dutta"));
	}
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json" )
	public PersonV1 getFirstVersionOfPersonAccept() {
		return new PersonV1("Sharad Kumar Dutta");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json" )
	public PersonV2 getSecondVersionOfPersonAccept() {
		return new PersonV2(new Name("Sharad", "Kumar", "Dutta"));
	}
}
