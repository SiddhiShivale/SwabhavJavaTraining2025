package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;

public class PigGame {
	private int choice; 
	private boolean turnOver;
	private int turnCount;
	private int turnScore;
	private int totalScore;
	
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();
	
	
	public void startGame() {
		System.out.println("*Pig Dice Game*");
		while(totalScore < 20) {
			playTurn();
		}
		System.out.println("You finished in " + turnCount + " turns.\nGame over!");
	}
	
	public void playTurn() {
		turnCount++;
		turnOver = false;
		turnScore = 0;
		
		System.out.println("\nTurn " + turnCount);
		
		while(!turnOver) {
			System.out.print("roll or hold? 1 = roll and 2 = hold: ");
			choice = scanner.nextInt();
			checkChoice();
		}
	}
	
	private void checkChoice() {
		if(choice == 1) {
			calculateRoll();
		}
		if(choice == 2) {
			calculateHold();				
		}
	}

	public void calculateHold() {
		totalScore = totalScore + turnScore;
		System.out.println("Score for current turn: " + turnScore);
		System.out.println("Total score: " + totalScore);
		turnOver = true;
		
	}
	
	public void calculateRoll() {
		int roll = random.nextInt(6) + 1;
		System.out.println("Dice: " + roll);
		
		if(roll == 1) {
			System.out.println("Turn over and no score.\n");
			turnScore = 0;	
			totalScore = 0;
			turnOver = true;
		}
		turnScore = turnScore + roll;
	}
}
