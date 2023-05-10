/**
 * 
 */
package com.sharad.learn.restwebservices.basic.versioning;

/**
 * @author koxkakku
 *
 */
public class PersonV1 {

	private String name;

	public PersonV1(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
