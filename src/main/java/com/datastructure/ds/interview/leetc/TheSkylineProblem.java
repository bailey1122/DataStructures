package com.datastructure.ds.interview.leetc;

import java.util.*;

public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<int[]> height = new ArrayList<int[]>();

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] :
                a[1] - b[1]);

        Queue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        q.offer(0);

        int prev = 0;

        for (int[] h : height) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            } else {
                q.remove(h[1]);
            }

            int curr = q.peek();

            if (prev != curr) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(h[0]);
                temp.add(curr);
                res.add(temp);

                prev = curr;
            }
        }

        return res;
    }
}
