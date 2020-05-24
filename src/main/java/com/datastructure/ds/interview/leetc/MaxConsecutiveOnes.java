package com.datastructure.ds.interview.leetc;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                consOnes++;
                max = Math.max(max, consOnes);
            } else {
                consOnes = 0;
            }
        }

        return max;
    }
}
