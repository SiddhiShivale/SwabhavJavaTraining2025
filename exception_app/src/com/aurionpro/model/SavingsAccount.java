package com.aurionpro.model;

import com.aurionpro.exceptions.MinimumBalanceViolationException;
import com.aurionpro.exceptions.NegativeAmountException;

public class SavingsAccount extends Account {
	private static int minimumBalance = 500;

	public int getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(int minimumBalance) {
		SavingsAccount.minimumBalance = minimumBalance;
	}

	public SavingsAccount(String accountNumber, String name, int balance, int minimumBalance) {
		super(accountNumber, name, balance);
		SavingsAccount.minimumBalance = minimumBalance;
	}

	public SavingsAccount(String accountNumber, String name, int balance) {
		super(accountNumber, name, balance);
	}

	@Override
	public void deposit(int depositAmount) {

		if (depositAmount < 0)
			throw new NegativeAmountException();

		setBalance(this.getBalance() + depositAmount);
		System.out.println("₹" + depositAmount + " is credited to your account.");

	}

	@Override
	public void withdraw(int withdrawAmount) {

		if (withdrawAmount < 0)
			throw new NegativeAmountException();

		if (this.getBalance() - withdrawAmount < minimumBalance)
			throw new MinimumBalanceViolationException();

		setBalance(getBalance() - withdrawAmount);
		System.out.println("₹" + withdrawAmount + " is debited from the account.");
		System.out.println("Updated Account Balance: " + getBalance());

	}
}
