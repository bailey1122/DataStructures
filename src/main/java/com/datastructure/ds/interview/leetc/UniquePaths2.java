package com.datastructure.ds.interview.leetc;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] != 1) {
                arr[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] != 1) {
                arr[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] != 1) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }

        return arr[rows - 1][cols - 1];
    }
}
