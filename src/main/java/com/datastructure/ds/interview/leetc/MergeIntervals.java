package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]));

        List<int[]> currentIntervals = new ArrayList<int[]>();
        int[] currentInterval = intervals[0];
        currentIntervals.add(currentInterval);

        for (int[] interval : intervals) {
            int currentBeginning = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBeginning = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBeginning) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                currentIntervals.add(currentInterval);
            }
        }

        return currentIntervals.toArray(new int[currentIntervals.size()][]);
    }
}