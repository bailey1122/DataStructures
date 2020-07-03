package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inbound = new int[numCourses];
        List<List<Integer>> outbound = new ArrayList<List<Integer>>(numCourses);

        initialize(inbound, outbound, prerequisites);

        return bfs(inbound, outbound);
    }

    private void initialize(int[] inbound, List<List<Integer>> outbound,
                            int[][] prerequisites){
        int n = inbound.length;

        while (n-- > 0) outbound.add(new ArrayList<Integer>());

        for (int[] p : prerequisites) {
            inbound[p[0]]++;
            outbound.get(p[1]).add(p[0]);
        }
    }

    private int[] bfs(int[] inbound, List<List<Integer>> outbound) {
        int[] res = new int[inbound.length];

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) q.offer(i);
        }

        int pos = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            res[pos++] = curr;

            for (int i : outbound.get(curr)) {
                if (--inbound[i] == 0) q.offer(i);
            }
        }

        return pos == inbound.length ? res : new int[0];
    }
}
