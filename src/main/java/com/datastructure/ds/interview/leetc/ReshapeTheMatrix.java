package com.datastructure.ds.interview.leetc;

// TC: O(m*n)
// SC: O(m*n)
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;

        if ((rows * columns) != (r * c)) return nums;

        int[][] res = new int[r][c];

        int rowNum = 0;
        int columnNum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[rowNum][columnNum] = nums[i][j];
                columnNum++;

                if (columnNum == c) {
                    columnNum = 0;
                    rowNum++;
                }
            }
        }

        return res;
    }
}
