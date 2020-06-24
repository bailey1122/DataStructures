package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        generateSubsets(nums, 0, res, new ArrayList<Integer>());

        return res;
    }

    private void generateSubsets(int[] nums, int p, List<List<Integer>> res,
                                 List<Integer> subset) {
        if (res.contains(subset)) return;
        res.add(new ArrayList<Integer>(subset));

        for (int i = p; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsets(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
