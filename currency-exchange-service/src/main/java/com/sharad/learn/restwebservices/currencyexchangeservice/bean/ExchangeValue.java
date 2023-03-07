/**
 * 
 */
package com.sharad.learn.restwebservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author XY57013
 *
 */
@Entity(name = "EXCHANGE_VALUE")
public class ExchangeValue {
	/**
	 * 
	 */
	protected ExchangeValue() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="exch_id")
	private Long id;
	
	@Column(name="exch_from")
	private String from;
	
	@Column(name="exch_to")
	private String to;
	
	@Column(name ="exch_conversion_multiple")
	private BigDecimal conversionMultiple;
	
	@Column(name = "exch_server_port")
	private int port;
	
	/**
	 * @param id
	 * @param from
	 * @param to
	 * @param conversionMultiple
	 */
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
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
