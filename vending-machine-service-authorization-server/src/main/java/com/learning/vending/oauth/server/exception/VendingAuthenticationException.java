package com.learning.vending.oauth.server.exception;

@SuppressWarnings("serial")
public class VendingAuthenticationException extends RuntimeException{

	public VendingAuthenticationException(String message) {
		super(message);
	}

	public VendingAuthenticationException(String message, Throwable t) {
		super(message, t);
	}

	public VendingAuthenticationException(Throwable t) {
		super(t);
	}
	
}
