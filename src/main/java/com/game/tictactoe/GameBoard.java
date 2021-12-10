package com.game.tictactoe;

import java.util.List;

public class GameBoard {
    private char [][] board;
    private int boardSize;

    public GameBoard(int boardSize) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
