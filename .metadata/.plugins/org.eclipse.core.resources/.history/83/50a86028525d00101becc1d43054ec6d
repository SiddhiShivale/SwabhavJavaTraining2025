package com.aurionpro.exceptions;

public class MinimumBalanceViolationException extends RuntimeException{
	
	private int minimumBalance;

	public MinimumBalanceViolationException(int minimumBalance) {
		super();
		this.minimumBalance = minimumBalance;
	}

	public MinimumBalanceViolationException() {
		super();
	}
	
	public String getMessage() {
		return "Sorry, you have to keep minimum balance of ₹" + minimumBalance;
	}
}
