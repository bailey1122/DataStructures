package com.datastructure.ds.interview.leetc;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];

        for (int i = 0; i < nums.length; i++) {
            res[i] = i % 2 == 0 ? nums[i / 2] : nums[n + (i / 2)];
        }

        return res;
    }
}
