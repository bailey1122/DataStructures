package com.datastructure.ds.interview.leetc;

public class TicTacToe{

    int[] rows;
    int[] columns;
    int diagonalSum;
    int antiDiagonalSum;

    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
    }

    public int move(int row, int column, int player) {
        int playerVal = (player == 1) ? 1 : -1;

        if (row == column) {
            diagonalSum += playerVal;
        }

        if (column == (columns.length - 1 - row)) {
            antiDiagonalSum += playerVal;
        }

        rows[row] += playerVal;
        columns[column] += playerVal;

        int size = rows.length;

        if ((Math.abs(rows[row]) == size) ||
            (Math.abs(columns[column]) == size) ||
            (Math.abs(diagonalSum) == size) ||
            (Math.abs(antiDiagonalSum) == size)) {
            return player;
        }

        return 0;
    }
}