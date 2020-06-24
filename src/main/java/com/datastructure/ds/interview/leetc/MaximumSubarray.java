package com.datastructure.ds.interview.leetc;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = subArray(nums, 0, nums.length - 1);

        return max;
    }

    private int subArray(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;
        int leftSum = subArray(nums, left, mid);
        int rightSum = subArray(nums, mid + 1, right);
        int midSum = midSubArray(nums, left, mid, right);

        if (leftSum >= rightSum && leftSum >= midSum) {
            return leftSum;
        } else if (rightSum >= leftSum && rightSum >= midSum) {
            return rightSum;
        } else {
            return midSum;
        }
    }

    private int midSubArray(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (leftSum < sum) leftSum = sum;
        }

        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (rightSum < sum) rightSum = sum;
        }

        return leftSum + rightSum;
    }
}
