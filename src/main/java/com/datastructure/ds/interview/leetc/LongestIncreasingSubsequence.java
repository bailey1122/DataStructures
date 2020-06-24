package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            count = Math.max(count, arr[i]);
        }

        return count;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        int count = 0;
        for (int n : nums) {
            int index = Arrays.binarySearch(arr, 0, count, n);

            if (index < 0) {
                index = -(index + 1);
            }
            arr[index] = n;
            if (index == count) {
                count++;
            }
        }

        return count;
    }
}
