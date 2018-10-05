package com.sigma.dto;

import org.springframework.http.HttpStatus;

import com.sigma.util.Constant;

public class ApiResponse<T> {

	private int code;
	private String message;
	private T data;
	
	public ApiResponse() {
		super();
	}
	
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
	
	public ApiResponse<?> success() {
		this.code = Constant.STATUS_SUCCESS;
		this.message = Constant.MESSAGE_SUCCESS;
		return this;
	}
	
	public ApiResponse<?> success(String message) {
		this.code = Constant.STATUS_SUCCESS;
		this.message = message;
		return this;
	}
	
	public ApiResponse<?> success(T data) {
		this.code = Constant.STATUS_SUCCESS;
		this.message = Constant.MESSAGE_SUCCESS;
		this.data = data;
		return this;
	}
	
	public ApiResponse<?> success(T data, String message) {
		this.code = Constant.STATUS_SUCCESS;
		this.message = message;
		this.data = data;
		return this;
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
