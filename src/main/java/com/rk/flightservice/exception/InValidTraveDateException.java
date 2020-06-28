package com.rk.flightservice.exception;

public class InValidTraveDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InValidTraveDateException(String message) {
       super(message);
	}

	public InValidTraveDateException(String message,Throwable cause) {
       super(message,cause);
	}

}
