package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(res, new ArrayList<Integer>(), 1, n, k);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list,
                        int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(list));

            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
