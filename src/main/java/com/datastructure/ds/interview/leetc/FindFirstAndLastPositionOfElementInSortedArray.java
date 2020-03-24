package com.datastructure.ds.interview.leetc;

// TC: O(log10(n))
// SC: O(1)
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = findStartingPoint(nums, target);
        arr[1] = findEndingPoint(nums, target);
        return arr;
    }

    public int findStartingPoint(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midPointer = start + (end - start) / 2;
            if (nums[midPointer] >= target) {
                end = midPointer - 1;
            } else {
                start = midPointer + 1;
            }

            if (nums[midPointer] == target) index = midPointer;
        }
        return index;
    }

    public int findEndingPoint(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midPointer = start + (end - start) / 2;
            if (nums[midPointer] <= target) {
                start = midPointer + 1;
            } else {
                end = midPointer - 1;
            }

            if (nums[midPointer] == target) index = midPointer;
        }
        return index;
    }
}
