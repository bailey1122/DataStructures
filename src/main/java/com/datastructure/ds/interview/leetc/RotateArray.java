package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        swap(nums, 0,  nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
