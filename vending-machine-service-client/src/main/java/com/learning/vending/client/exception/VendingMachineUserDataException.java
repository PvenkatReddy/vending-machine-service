package com.learning.vending.client.exception;

@SuppressWarnings("serial")
public class VendingMachineUserDataException extends RuntimeException{

	public VendingMachineUserDataException(String message) {
		super(message);
	}

	public VendingMachineUserDataException(String message, Throwable t) {
		super(message, t);
	}

	public VendingMachineUserDataException(Throwable t) {
		super(t);
	}
}
