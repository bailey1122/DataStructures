package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(1)
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int num = 0;

        for (int n : nums) {
            num ^= n;
        }

        return num;
    }
}
