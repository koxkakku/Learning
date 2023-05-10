/**
 * 
 */
package com.sharad.learn.restwebservices.basic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author koxkakku
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class UserNotFoundException extends RuntimeException {


	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}
