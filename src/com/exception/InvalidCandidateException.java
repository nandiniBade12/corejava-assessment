package com.exception;

public class InvalidCandidateException extends Exception{

	private static final long serialVersionUID = 1L;

	// Include a public Single argument Constructor and set the message through super class Constructor
	public InvalidCandidateException(String message) {
		super(message);
	}
	
}