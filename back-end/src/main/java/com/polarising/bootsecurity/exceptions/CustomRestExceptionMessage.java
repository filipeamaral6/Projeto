package com.polarising.bootsecurity.exceptions;

public class CustomRestExceptionMessage extends RuntimeException {
	
	private static final long serialVersionUID = 5377334777759551943L;

	public CustomRestExceptionMessage(String message) {
		super(message);
	}
	
	public CustomRestExceptionMessage(String message, Throwable cause) {
		super(message, cause);
	}
}
