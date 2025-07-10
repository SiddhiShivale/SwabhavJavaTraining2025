package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;
import com.aurionpro.exceptions.MinimumBalanceViolationException;
import com.aurionpro.exceptions.NegativeAmountException;
import com.aurionpro.exceptions.OverdraftLimitReachException;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingsAccount;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		createAccount(scanner, random);
	}

	private static void createAccount(Scanner scanner, Random random) {

		SavingsAccount savingsAccount = null;
		CurrentAccount currentAccount = null;
		int choice;

		System.out.print("1. Savings\n2. Current\nChoose account type: ");
		int accountType = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("\nCreate an account ->");
		int randomNumber = random.nextInt(5000000) + 1000000;
		String accountNumber = "IDBI1000" + randomNumber;

		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		System.out.print("Enter amount: ");
		int balance = scanner.nextInt();

		System.out.println("Your account number is: " + accountNumber);

		if (accountType == 1) {
			savingsAccount = new SavingsAccount(accountNumber, name, balance);
		}
		if (accountType == 2) {
			currentAccount = new CurrentAccount(accountNumber, name, balance);
		}

		do {

			System.out.println("\n1. View Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				if (accountType == 1) {
					System.out.println(savingsAccount.getBalance());
					continue;
				}
				System.out.println(currentAccount.getBalance());
				break;

			case 2:
				try {
					System.out.print("Enter amount to deposit: ");
					int depositAmount = scanner.nextInt();
				
					if (accountType == 1) {
						savingsAccount.deposit(depositAmount);
						continue;
					}
					currentAccount.deposit(depositAmount);
					break;
					
				} catch(NegativeAmountException exception) {
					System.out.println(exception.getMessage());
					break;
				}

			case 3:
				try {
					System.out.print("Enter amount to withdraw: ");
					int amount = scanner.nextInt();
	
					if (accountType == 1) {
						savingsAccount.withdraw(amount);
						continue;
					}
					currentAccount.withdraw(amount);
					break;
					
				} catch(NegativeAmountException exception) {
					System.out.println(exception.getMessage());
				}
				catch(MinimumBalanceViolationException exception) {
					System.out.println(exception.getMessage());
				}
				catch(OverdraftLimitReachException exception) {
					System.out.println(exception.getMessage());
				}
				catch(Exception exception) {
					System.out.println("Something went wrong.");
				}
			}
			
		} while (choice != 4);
	}
}
