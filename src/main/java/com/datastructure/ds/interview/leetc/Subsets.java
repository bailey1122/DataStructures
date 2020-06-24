package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // TC: O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                res.add(new ArrayList<Integer>(res.get(j)));
                res.get(res.size() - 1).add(nums[i]);
            }
        }

        return res;
    }

    // TC: O(n)
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> subset = new ArrayList<Integer>();
        generateSubsets2(nums, 0, res, subset);

        return res;
    }

    private void generateSubsets2(int[] nums, int p,
                                 List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = p; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubsets2(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }
}

