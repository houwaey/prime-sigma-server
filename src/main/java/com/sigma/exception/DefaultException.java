package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class DefaultException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	
	public DefaultException(String message) {
		super(message);
	}
	
	public DefaultException(Throwable e) {
		super(e);
	}
	
	public DefaultException(String message, Throwable e) {
		super(message, e);
	}
	
	public DefaultException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
	public DefaultException(HttpStatus httpStatus, Throwable e) {
		super(e);
		this.httpStatus = httpStatus;
	}
	
	public DefaultException(HttpStatus httpStatus, String message, Throwable e) {
		super(message, e);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
