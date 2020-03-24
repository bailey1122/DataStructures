package com.datastructure.ds.interview.leetc;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;

        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }

        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int l = nums.length - 1; l > k; l--) {
            if (nums[k] < nums[l]) {
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                break;
            }
        }

        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
