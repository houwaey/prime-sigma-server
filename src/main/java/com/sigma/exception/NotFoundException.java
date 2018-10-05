package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message, Throwable e) {
		super(HttpStatus.NOT_FOUND, message, e);
	}

	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

	public NotFoundException(Throwable e) {
		super(HttpStatus.NOT_FOUND, e);
	}
	
}
