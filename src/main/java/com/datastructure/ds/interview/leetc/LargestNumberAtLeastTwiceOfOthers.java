package com.datastructure.ds.interview.leetc;

public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int max = -1, second = -1, index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }

        return 2 * second <= max ? index : -1;
    }
}
