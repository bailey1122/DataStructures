package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

// TC: O(nlogn)
// SC: O(n)
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(nums);
        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }
}
