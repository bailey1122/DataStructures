package com.datastructure.ds.interview.leetc;

// TC: O(N^2), where N is the number of rows (and columns) of the grid
// SC: O(N)
public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;

        int[] maxRows = new int[n];
        int[] maxColumns = new int[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxColumns[j] = Math.max(maxColumns[j], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(maxRows[i], maxColumns[j]) - grid[i][j];
            }
        }

        return res;
    }
}
