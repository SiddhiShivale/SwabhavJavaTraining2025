package com.aurionpro.model;

public class Board {

	private char[][] grid;
	private final int SIZE = 3;
	
	public char[][] getGrid() {
		return grid;
	}
	
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public int getSIZE() {
		return SIZE;
	}

	public Board() {
		grid = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = ' ';
			}
		}
	}

	public boolean placeMark(int row, int col, char mark) {
		if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == ' ') {
			grid[row][col] = mark;
			return true;
		}
		return false;
	}

	public boolean checkWin(char mark) {
		for (int i = 0; i < SIZE; i++) {
			if (grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark)
				return true;
			if (grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark)
				return true;
		}
		return (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark)
				|| (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark);
	}

	public boolean isFull() {
		for (char[] row : grid) {
			for (char cell : row) {
				if (cell == ' ')
					return false;
			}
		}
		return true;
	}

}
