package com.aurionpro.model;

public class Game {

	private Board board;
	private Player currentPlayer;
	private boolean gameOver;
	private char winner;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public char[][] getBoard() {
		return board.getGrid();
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public char getWinner() {
		return winner;
	}
	
	public void setWinner(char winner) {
		this.winner = winner;
	}

	public Game() {
		board = new Board();
		currentPlayer = new Player('X');
		gameOver = false;
		winner = ' ';
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

	public void switchPlayer() {
		currentPlayer = new Player(currentPlayer.getMark() == 'X' ? 'O' : 'X');
	}

}
