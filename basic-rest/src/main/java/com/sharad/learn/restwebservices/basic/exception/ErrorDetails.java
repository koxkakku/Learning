/**
 * 
 */
package com.sharad.learn.restwebservices.basic.exception;

import java.time.LocalDateTime;

/**
 * @author XY57013
 *
 */
public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String errorDetails;
	public ErrorDetails(LocalDateTime timeStamp, String message, String errorDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
}
