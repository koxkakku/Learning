/**
 * 
 */
package com.sharad.learn.restwebservices.basic.versioning;

/**
 * @author koxkakku
 *
 */
public class PersonV2 {

	private Name name;

	public PersonV2(Name name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}
