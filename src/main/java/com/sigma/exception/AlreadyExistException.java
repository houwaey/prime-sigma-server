package com.sigma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class AlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlreadyExistException(String message) {
		super(message);
	}
	
	public AlreadyExistException(String message, Throwable e) {
		super(message, e);
	}

}
