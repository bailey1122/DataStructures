package com.datastructure.ds.interview.leetc;

public class NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int) Math.pow(10, 9) + 7;

        long[][] arr = new long[d + 1][target + 1];
        arr[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        arr[i][j] = (arr[i][j] + arr[i - 1][j - k]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }

        return (int) arr[d][target];
    }
}
