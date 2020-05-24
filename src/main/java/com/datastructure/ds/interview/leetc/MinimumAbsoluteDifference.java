package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDifference = Math.min(minDifference, Math.abs(arr[i - 1] - arr[i]));
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i - 1] - arr[i]) == minDifference) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }

        return res;
    }
}
