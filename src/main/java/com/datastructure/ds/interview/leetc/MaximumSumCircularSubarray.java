package com.datastructure.ds.interview.leetc;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int total = 0, minSum = A[0], currMin = 0, maxSum = A[0], currMax = 0;

        for (int a : A) {
            currMin = Math.min(currMin + a, a);
            minSum = Math.min(minSum, currMin);

            currMax = Math.max(currMax + a, a);
            maxSum = Math.max(maxSum, currMax);

            total += a;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
