package com.datastructure.ds.interview.leetc;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0, level = 0, l = 0, r = height.length - 1;

        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }

        return res;
    }
}
