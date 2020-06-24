package com.datastructure.ds.interview.leetc;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        return S > sum || (S + sum) % 2 > 0 ? 0 : subsetSum(nums,
                (S + sum) >>> 1);
    }

    private int subsetSum(int[] nums, int S) {
        int[] arr = new int[S + 1];
        arr[0] = 1;

        for (int n : nums) {
            for (int i = S; i >= n; i--) {
                arr[i] += arr[i - n];
            }
        }

        return arr[S];
    }
}
