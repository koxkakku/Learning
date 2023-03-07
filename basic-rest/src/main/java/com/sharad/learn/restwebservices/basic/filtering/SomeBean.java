package com.sharad.learn.restwebservices.basic.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties({"field1","field3"})//not recomended as if field name change it wont work
public class SomeBean {

	private String field1;
	@JsonIgnore //recomended
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	/**
	 * @return the field1
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * @return the field2
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * @return the field3
	 */
	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}
