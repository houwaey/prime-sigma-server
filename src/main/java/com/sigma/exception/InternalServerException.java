package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public InternalServerException(String message, Throwable e) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message, e);
	}

	public InternalServerException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}

	public InternalServerException(Throwable e) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, e);
	}
	
}
