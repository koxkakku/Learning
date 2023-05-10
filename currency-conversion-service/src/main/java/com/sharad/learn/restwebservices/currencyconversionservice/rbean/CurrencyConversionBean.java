/**
 * 
 */
package com.sharad.learn.restwebservices.currencyconversionservice.rbean;

import java.math.BigDecimal;

/**
 * @author koxkakku
 *
 */
public class CurrencyConversionBean {

	/**
	 * 
	 */
	protected CurrencyConversionBean() {
	}
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	private BigDecimal quantity;
	private BigDecimal convertedValue;
	
	/**
	 * @param id
	 * @param from
	 * @param to
	 * @param quantity
	 * @param conversionMultiple
	 * @param convertedValue
	 * @param port
	 */
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal convertedValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.convertedValue = convertedValue;
		this.port = port;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the conversionMultiple
	 */
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	/**
	 * @param conversionMultiple the conversionMultiple to set
	 */
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	/**
	 * @return the convertedValue
	 */
	public BigDecimal getConvertedValue() {
		return convertedValue;
	}
	/**
	 * @param convertedValue the convertedValue to set
	 */
	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
