package com.datastructure.ds.interview.leetc;

// TC: O(R * C), where R is the number of rows in the grid, and C is the number of columns
// SC: O(R * C)
public class MaxAreaOfIsland {

    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int maxSum = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maxSum = Math.max(maxSum, getArea(i, j, grid));
            }
        }

        return maxSum;
    }

    private int getArea(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length || column < 0 ||
                column >= grid[row].length || visited[row][column] ||
                grid[row][column] == 0) {
            return 0;
        }

        visited[row][column] = true;

        return 1 + getArea(row - 1, column, grid) +
                getArea(row + 1, column, grid) +
                getArea(row, column - 1, grid) +
                getArea(row, column + 1, grid);
    }
}
