package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // TC: O(n)
    // SC: O(n)
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;

        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }

        return false;
    }

    // TC: O(nlogn)
    // SC: O(1)
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length == 0) return false;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }

        return false;
    }
}
