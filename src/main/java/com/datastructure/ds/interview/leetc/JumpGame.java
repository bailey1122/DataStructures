package com.datastructure.ds.interview.leetc;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxDistance || maxDistance >= nums.length - 1) {
                break;
            }

            maxDistance = Math.max(maxDistance, i + nums[i]);
        }

        return maxDistance >= nums.length - 1;
    }
}
