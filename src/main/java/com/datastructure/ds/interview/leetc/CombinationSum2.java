package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);

        findCombinations(candidates, new ArrayList<Integer>(), res, target, 0);

        return res;
    }

    private void findCombinations(int[] candidates, List<Integer> combinations,
                                  List<List<Integer>> res, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(combinations));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }

            if (i > start && candidates[i] == candidates[i - 1]) continue;

            combinations.add(candidates[i]);
            findCombinations(candidates, combinations, res, target - candidates[i], i + 1);
            combinations.remove(combinations.size() - 1);
        }
    }
}
