package com.sigma.dto;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

	private int code;
	private String message;
	private T data;
	
	public ApiResponse(HttpStatus httpStatus) {
		this.code = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
	}
	
	public ApiResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ApiResponse(T data, HttpStatus httpStatus) {
		this.code = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
		this.data = data;
	}
	
	public ApiResponse(T data, int code, String message) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
}
