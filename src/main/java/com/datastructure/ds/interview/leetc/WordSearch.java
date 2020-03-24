package com.datastructure.ds.interview.leetc;

public class WordSearch {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int row_length = board.length;
        int column_length = board[0].length;
        visited = new boolean[row_length][column_length];

        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < column_length; j++) {
                if (board[i][j] == word.charAt(0)
                        && findWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, int index, char[][] board,
                             String word) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
                visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        if (findWord(i + 1, j, index + 1, board, word) ||
                findWord(i - 1, j, index + 1, board, word) ||
                findWord(i, j + 1, index + 1, board, word) ||
                findWord(i, j - 1, index + 1, board, word)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
