package com.datastructure.ds.interview.leetc;

public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {
        int m = Integer.MIN_VALUE, n = m;

        for (int i : nums) {
            if (i >= m) {
                n = m;
                m = i;
            } else if (i > n) {
                n = i;
            }
        }

        return (m - 1) * (n - 1);
    }
}
