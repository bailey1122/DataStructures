package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        boolean[] seen = new boolean[nums.length];
        dfs(nums, seen, res, new ArrayList<Integer>());

        return res;
    }

    private void dfs(int[] nums, boolean[] seen, List<List<Integer>> res,
                     List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !seen[i - 1]) continue;
            seen[i] = true;
            list.add(nums[i]);
            dfs(nums, seen, res, list);
            seen[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
