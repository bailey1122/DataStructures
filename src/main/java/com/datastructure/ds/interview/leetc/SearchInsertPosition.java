package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] < target) {
            return right + 1;
        } else if (nums[left] >= target) {
            return left;
        } else {
            return right;
        }
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            index = -(index + 1);
        }

        return index;
    }
}
