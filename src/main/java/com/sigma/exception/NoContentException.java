package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class NoContentException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public NoContentException(String message, Throwable e) {
		super(HttpStatus.NO_CONTENT, message, e);
	}

	public NoContentException(String message) {
		super(HttpStatus.NO_CONTENT, message);
	}

	public NoContentException(Throwable e) {
		super(HttpStatus.NO_CONTENT, e);
	}
	
}
