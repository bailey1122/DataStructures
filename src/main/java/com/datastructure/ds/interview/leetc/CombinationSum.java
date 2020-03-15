package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) return results;

        Arrays.sort(candidates);

        findCombinations(candidates, new ArrayList<Integer>(), results, target, 0);
        return results;
    }

    private void findCombinations(int[] candidates, List<Integer> combination,
                                  List<List<Integer>> results, int target, int start) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            findCombinations(candidates, combination, results, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
