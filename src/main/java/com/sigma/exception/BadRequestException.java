package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message, Throwable e) {
		super(HttpStatus.BAD_REQUEST, message, e);
	}

	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}

	public BadRequestException(Throwable e) {
		super(HttpStatus.BAD_REQUEST, e);
	}
	
}
