package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(1)
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }

        return res;
    }
}
