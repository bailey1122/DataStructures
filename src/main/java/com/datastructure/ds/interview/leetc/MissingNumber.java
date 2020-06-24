package com.datastructure.ds.interview.leetc;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int resX = 0, i = 0;

        for (; i < nums.length; i++) {
            resX = resX ^ i ^ nums[i];
        }

        return resX ^ i;
    }
}
