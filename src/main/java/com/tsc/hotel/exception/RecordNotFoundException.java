package com.tsc.hotel.exception;

public class RecordNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	private String message;

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
