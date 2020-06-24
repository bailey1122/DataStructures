package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC: O(n^2)
// SC: O(n)
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list = new ArrayList<Integer>(
                triangle.get(triangle.size() - 1));

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                list.set(j, Math.min(list.get(j), list.get(j + 1)) +
                        triangle.get(i).get(j));
            }
        }

        return list.get(0);
    }
}
