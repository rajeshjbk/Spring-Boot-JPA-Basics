package com.raj.exception;

public class BankAccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException() {
		super();
	}
	
	public BankAccountNotFoundException(String msg) {
		super(msg);
	}

}
