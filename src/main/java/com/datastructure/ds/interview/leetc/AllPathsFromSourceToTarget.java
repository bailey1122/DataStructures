package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> list = new ArrayList<Integer>();
        list.add(0);

        helper(graph, 0, list, res);

        return res;
    }

    private void helper(int[][] graph, int edge, List<Integer> list,
                        List<List<Integer>> res) {
        if (edge == graph.length - 1) {
            res.add(new ArrayList<Integer>(list));

            return;
        }

        for (int e : graph[edge]) {
            list.add(e);
            helper(graph, e, list, res);
            list.remove(list.size() - 1);
        }
    }
}
