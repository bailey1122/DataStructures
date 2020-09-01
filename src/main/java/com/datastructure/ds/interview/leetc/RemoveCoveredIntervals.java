package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0, right = -1, left = -1;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] i : intervals) {
            if (i[0] > left && i[1] > right) {
                left = i[0];
                count++;
            }

            right = Math.max(right, i[1]);
        }

        return count;
    }
}
