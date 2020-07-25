package com.datastructure.ds.interview.leetc;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int n : nums) {
            if (i < 2 || nums[i - 2] < n) {
                nums[i++] = n;
            }
        }

        return i;
    }
}
