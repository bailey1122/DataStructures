package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) res.add(index + 1);
            nums[index] = -nums[index];
        }

        return res;
    }
}
