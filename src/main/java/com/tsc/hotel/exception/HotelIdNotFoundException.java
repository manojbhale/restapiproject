package com.tsc.hotel.exception;

public class HotelIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HotelIdNotFoundException() {
		super();
		
	}

	public HotelIdNotFoundException(String msg) {
		super(msg);

	}
	
	

}
