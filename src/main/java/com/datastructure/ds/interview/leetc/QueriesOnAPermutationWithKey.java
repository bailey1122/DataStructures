package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;

public class QueriesOnAPermutationWithKey {

    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = list.indexOf(q);
            list.remove(idx);
            list.addFirst(q);
            queries[i] = idx;
        }

        return queries;
    }
}
