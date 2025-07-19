package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void testInitialBoardIsEmpty() {
        Game game = new Game();
        char[][] board = game.getBoard();
        for (char[] row : board) {
            for (char cell : row) {
                assertEquals(' ', cell);
            }
        }
    }

    @Test
    public void testPlayerMove() {
        Game game = new Game();
        boolean moveResult = game.makeMove(0, 0); // X starts
        assertTrue(moveResult);
        assertEquals('X', game.getBoard()[0][0]);
    }

    @Test
    public void testInvalidMoveOccupiedCell() {
        Game game = new Game();
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0)); // already taken
    }

}
