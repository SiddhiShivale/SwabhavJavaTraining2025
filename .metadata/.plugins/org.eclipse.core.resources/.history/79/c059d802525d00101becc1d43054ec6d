package com.aurionpro.model;

import com.aurionpro.exceptions.NegativeAmountException;
import com.aurionpro.exceptions.OverdraftLimitReachException;

public class CurrentAccount extends Account {
	private static int overDraftLimit = 50000;

	public int getOverDraftlimit() {
		return overDraftLimit;
	}

	public void setOverDraftlimit(int overDraftlimit) {
		overDraftLimit = overDraftlimit;
	}

	public CurrentAccount(String accountNumber, String name, int balance) {
		super(accountNumber, name, balance);
	}
	
	public CurrentAccount(String accountNumber, String name, int balance, int overDraftLimit) {
		super(accountNumber, name, balance);
		CurrentAccount.overDraftLimit = overDraftLimit;
	}
	
	@Override
	public void deposit(int depositAmount) {
		if(depositAmount < 0) 
			throw new NegativeAmountException();
	
		setBalance(this.getBalance() + depositAmount);
		System.out.println("₹" + depositAmount + " is credited to your account.");
		
	}
	
	@Override
	public void withdraw(int withdrawAmount) {

		if(withdrawAmount < 0) 
			throw new NegativeAmountException();
		
		if(getBalance() + overDraftLimit < withdrawAmount)
			throw new OverdraftLimitReachException();
		
		setBalance(getBalance() - withdrawAmount);
		System.out.println("₹" + withdrawAmount + " is debited from the account.");
		System.out.println("Updated Account Balance: " + getBalance());

		
	
	}
}
