package com.aurionpro.exceptions;

public class OverdraftLimitReachException extends RuntimeException{
	
	private int overdraftLimit;

	public OverdraftLimitReachException(int overdraftLimit) {
		super();
		this.overdraftLimit = overdraftLimit;
	}

	public OverdraftLimitReachException() {
		super();
	}
	
	public String getMessage() {
		return "Transaction Failed! Insufficient Balance & Overdraft.";
	}
	
}
