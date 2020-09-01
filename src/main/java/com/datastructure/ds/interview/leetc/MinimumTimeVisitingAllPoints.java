package com.datastructure.ds.interview.leetc;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i], prev = points[i - 1];

            res += Math.max(Math.abs(curr[0] - prev[0]),
                    Math.abs(curr[1] - prev[1]));
        }

        return res;
    }
}
