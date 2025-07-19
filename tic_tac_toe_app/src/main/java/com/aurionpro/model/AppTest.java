package com.aurionpro.model;

import java.util.Scanner;

public class AppTest {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        Game game = new Game();

	        while (!game.isGameOver()) {
	            printBoard(game.getBoard());
	            System.out.print("Enter row and column (0-2): ");
	            int row = scanner.nextInt();
	            int col = scanner.nextInt();
	            if (!game.makeMove(row, col)) {
	                System.out.println("Invalid move. Try again.");
	            }
	        }

	        printBoard(game.getBoard());
	        char winner = game.getWinner();
	        if (winner != ' ') {
	            System.out.println("Winner is: " + winner);
	        } else {
	            System.out.println("It's a draw!");
	        }
	    }

	    private static void printBoard(char[][] board) {
	        for (char[] row : board) {
	            for (char cell : row) {
	                System.out.print("|" + (cell == ' ' ? '_' : cell));
	            }
	            System.out.println("|");
	        }
	}

}
