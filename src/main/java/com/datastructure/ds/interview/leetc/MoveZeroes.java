package com.datastructure.ds.interview.leetc;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i < j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
