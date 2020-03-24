package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

// TC: O(n)
// SC: O(1)
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] char_count = new int[26];
        for (char c : tasks) {
            char_count[c - 'A']++;
        }

        Arrays.sort(char_count);
        int maxEl = char_count[25] - 1;
        int idle = maxEl * n;

        for (int i = 24; i >= 0 && char_count[i] > 0; i--) {
            idle -= Math.min(char_count[i], maxEl);
        }

        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}
