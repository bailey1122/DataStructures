package com.datastructure.ds.interview.leetc;

// TC: O(logn)
// SC: O(1)
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;

            if (target == nums[midpoint]) {
                return midpoint;
            } else if (target < nums[midpoint]) {
                right = midpoint - 1;
            } else if (target > nums[midpoint]) {
                left = midpoint + 1;
            }
        }

        return - 1;
    }
}
