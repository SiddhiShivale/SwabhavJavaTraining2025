package com.aurionpro.model;

public class Game {

	private Board board;
	private Player currentPlayer;
	private Player playerX;
	private Player playerO;
	private boolean gameOver;
	private char winner;

	public Game(String player1Name, String player2Name) {
		board = new Board();
		playerX = new Player('X', player1Name);
		playerO = new Player('O', player2Name);
		currentPlayer = playerX;
		gameOver = false;
		winner = ' ';
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public char[][] getBoard() {
		return board.getGrid();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public char getWinner() {
		return winner;
	}

	public String getWinnerName() {
		return winner == 'X' ? playerX.getName() : playerO.getName();
	}

	public boolean makeMove(int row, int col) {
		if (gameOver || !board.placeMark(row, col, currentPlayer.getMark())) {
			return false;
		}

		if (board.checkWin(currentPlayer.getMark())) {
			gameOver = true;
			winner = currentPlayer.getMark();
		} else if (board.isFull()) {
			gameOver = true;
		} else {
			switchPlayer();
		}
		return true;
	}

	private void switchPlayer() {
		currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
	}
}
