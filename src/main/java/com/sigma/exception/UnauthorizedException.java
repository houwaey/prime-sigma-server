package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String message, Throwable e) {
		super(HttpStatus.UNAUTHORIZED, message, e);
	}

	public UnauthorizedException(String message) {
		super(HttpStatus.UNAUTHORIZED, message);
	}

	public UnauthorizedException(Throwable e) {
		super(HttpStatus.UNAUTHORIZED, e);
	}

}
