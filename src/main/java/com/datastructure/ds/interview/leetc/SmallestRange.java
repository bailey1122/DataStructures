package com.datastructure.ds.interview.leetc;

public class SmallestRange {

    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];

        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        if (min + K >= max - K) {
            return 0;
        } else {
            return (max - K) - (min + K);
        }
    }
}
