/**
 * 
 */
package com.sharad.learn.restwebservices.limitsservice.bean;

/**
 * @author XY57013
 *
 */
public class LimitConfiguration {
	private int minimum;
	private int maximum;

	protected LimitConfiguration() {
	}
	/**
	 * @param minimum
	 * @param maximum
	 */
	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}
	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}
	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	@Override
	public String toString() {
		return "LimitConfiguration [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
}
