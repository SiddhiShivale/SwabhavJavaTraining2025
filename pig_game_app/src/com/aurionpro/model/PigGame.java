package com.aurionpro.model;
import java.util.Scanner;

public class PigGame {
	private static final int MAX_TURNS = 5;
	private static final int WINNING_SCORE = 20;

	private final Scanner scanner;
	private final Dice dice;
	private final Score totalScore;
	private int turnCount;

	public PigGame(Scanner scanner) {
		this.scanner = scanner;
		this.dice = new Dice();
		this.totalScore = new Score(0);
		this.turnCount = 0;
	}

	public void play() {
		System.out.println("*Pig problem*");

		while (canPlayMore()) {
			playTurn();
		}

		System.out.println("You finished in " + turnCount + " turns.\nGame over!");
	}

	private boolean canPlayMore() {
		return turnCount < MAX_TURNS && totalScore.getValue() < WINNING_SCORE;
	}

	private void playTurn() {
		turnCount++;
		Score turnScore = new Score(0);
		boolean turnOver = false;

		System.out.println("\nTurn " + turnCount);

		while (!turnOver) {
			System.out.print("roll or hold? 1 = roll and 2 = hold: ");
			int choice = scanner.nextInt();

			if (choice == 1) {
				int roll = dice.roll();
				System.out.println("Dice: " + roll);

				if (roll == 1) {
					System.out.println("Turn over and no score.\n");
					totalScore.reset();
					turnOver = true;
					continue;
				}

				turnScore = turnScore.add(roll);
			}

			if (choice == 2) {
				totalScore.addInPlace(turnScore);
				System.out.println("Score for current turn: " + turnScore.getValue());
				System.out.println("Total score: " + totalScore.getValue());
				turnOver = true;
			}
		}
	}
}
