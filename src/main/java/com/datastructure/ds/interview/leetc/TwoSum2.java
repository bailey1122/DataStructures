package com.datastructure.ds.interview.leetc;

// TC: O(n^2)
// SC: O(1)
public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum");
    }
}
