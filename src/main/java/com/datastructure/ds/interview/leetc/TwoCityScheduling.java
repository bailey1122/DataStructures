package com.datastructure.ds.interview.leetc;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i][0] = arr[i - 1][0] + costs[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            arr[0][j] = arr[0][j - 1] + costs[j - 1][1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Math.min(arr[i][j - 1] + costs[i + j - 1][1],
                        arr[i - 1][j] + costs[i + j - 1][0]);
            }
        }

        return arr[n][n];
    }
}
