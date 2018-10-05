package com.sigma.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends DefaultException {

	private static final long serialVersionUID = 1L;

	public AlreadyExistException(String message, Throwable e) {
		super(HttpStatus.PRECONDITION_REQUIRED, message, e);
	}

	public AlreadyExistException(String message) {
		super(HttpStatus.PRECONDITION_FAILED, message);
	}

	public AlreadyExistException(Throwable e) {
		super(HttpStatus.PRECONDITION_FAILED, e);
	}
	
}