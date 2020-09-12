package com.awon.demo.personapi;

public class ApiRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7416720498931049815L;

	public ApiRequestException(String message) {
		super(message);
		
	}

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
		
	}
}
