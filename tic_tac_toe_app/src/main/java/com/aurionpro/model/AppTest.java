package com.aurionpro.model;

import java.util.Scanner;

public class AppTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name for Player 1 (X): ");
        String player1 = scanner.nextLine();
        System.out.print("Enter name for Player 2 (O): ");
        String player2 = scanner.nextLine();

        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game(player1, player2);

            while (!game.isGameOver()) {
                printBoard(game.getBoard());
                System.out.println(game.getCurrentPlayer().getName() + "'s turn (" + game.getCurrentPlayer().getMark() + ")");
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
                System.out.println("Winner is: " + game.getWinnerName() + " (" + winner + ")");
            } else {
                System.out.println("It's a draw!");
            }

            scanner.nextLine(); 
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }

        scanner.close();
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
