package com.datastructure.ds.interview.leetc;

public class JumpGameII {

    public int jump(int[] nums) {
        int count = 0, currEnd = 0, currFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, nums[i] + i);

            if (i == currEnd) {
                count++;
                currEnd = currFarthest;
            }
        }

        return count;
    }
}
