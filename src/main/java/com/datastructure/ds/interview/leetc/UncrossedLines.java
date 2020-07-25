package com.datastructure.ds.interview.leetc;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, arr[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }

        return arr[m][n];
    }
}
