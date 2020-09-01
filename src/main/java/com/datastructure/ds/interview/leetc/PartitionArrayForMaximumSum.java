package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length, arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                max = Math.max(max, A[i - j + 1]);
                arr[i] = Math.max(arr[i], (i >= j ? arr[i - j] : 0) + max * j);
            }
        }

        return arr[n - 1];
    }
}
