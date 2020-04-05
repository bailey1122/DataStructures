package com.datastructure.ds.interview.leetc;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n - 1;

        int columnBegin = 0;
        int columnEnd = n - 1;

        int counter = 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            for (int j = columnBegin; j <= columnEnd; j++) {
                res[rowBegin][j] = counter++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][columnEnd] = counter++;
            }
            columnEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = columnEnd; j >= columnBegin; j--) {
                    res[rowEnd][j] = counter++;
                }
            }
            rowEnd--;

            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res[i][columnBegin] = counter++;
                }
            }
            columnBegin++;
        }

        return res;
    }
}
