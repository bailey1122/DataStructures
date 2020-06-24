package com.datastructure.ds.interview.leetc;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 && j != 0) grid[i][j] +=
                        Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
