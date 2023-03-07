/**
 * 
 */
package com.sharad.learn.restwebservices.basic.versioning;

/**
 * @author XY57013
 *
 */
public class Name {

	private String firstName;
	private String middleNmae;
	private String lastName;

	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleNmae = middleName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the middleNmae
	 */
	public String getMiddleNmae() {
		return middleNmae;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleNmae=" + middleNmae + ", lastName=" + lastName + "]";
	}

}
