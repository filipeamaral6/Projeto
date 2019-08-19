package com.polarising.bootsecurity.exceptions;

public class CustomExceptionMessage extends RuntimeException{
	
	private static final long serialVersionUID = 5377334777759551943L;

	public CustomExceptionMessage(String message) {
		super(message);
	}

	public CustomExceptionMessage(String message, Throwable cause) {
		super(message, cause);
	}
}
