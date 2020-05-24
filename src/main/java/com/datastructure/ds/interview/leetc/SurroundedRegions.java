package com.datastructure.ds.interview.leetc;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 2 || board[0].length < 2) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) { // traverse rows
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                boundaryDFS(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) { // traverse columns
            if (board[0][j] == 'O') {
                boundaryDFS(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                boundaryDFS(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }

        if (i > 1 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (j < board[i].length - 2 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }
    }
}
