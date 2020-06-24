package com.datastructure.ds.interview.leetc;

public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lp = 0;
        for (int rp = 0; rp < nums.length; rp++) {
            if (nums[lp] != nums[rp]) {
                nums[++lp] = nums[rp];
            }
        }

        return lp + 1;
    }
}
