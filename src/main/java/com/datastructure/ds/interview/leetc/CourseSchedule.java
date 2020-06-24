package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inbound = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];

            if (matrix[out][in] == 0) {
                inbound[in]++;
            }
            matrix[out][in] = 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--inbound[i] == 0) queue.offer(i);
                }
            }
        }

        return count == numCourses;
    }
}
