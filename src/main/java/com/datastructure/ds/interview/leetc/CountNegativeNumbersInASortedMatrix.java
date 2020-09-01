package com.datastructure.ds.interview.leetc;

public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int m = grid.length - 1, n = grid[0].length, p = 0, count = 0;

        while (m >= 0 && p < n) {
            if (grid[m][p] < 0) {
                m--;
                count += n - p;
            } else {
                p++;
            }
        }

        return count;
    }
}
