package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String message, Throwable e) {
		super(HttpStatus.FORBIDDEN, message, e);
	}

	public ForbiddenException(String message) {
		super(HttpStatus.FORBIDDEN, message);
	}

	public ForbiddenException(Throwable e) {
		super(HttpStatus.FORBIDDEN, e);
	}
	
}
