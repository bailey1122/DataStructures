package com.datastructure.ds.interview.leetc;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int res = 0, count[] = new int[101];

        for (int n : nums) {
            res += count[n]++;
        }

        return res;
    }
}
