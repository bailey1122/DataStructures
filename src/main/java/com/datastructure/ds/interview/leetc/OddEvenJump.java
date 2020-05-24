package com.datastructure.ds.interview.leetc;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

    public int oddEvenJumps(int[] A) {
        int n = A.length;

        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n - 1] = true;
        lower[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(A[n - 1], n - 1);

        int goodStartingIndexCount = 1;

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry higherEntry = map.ceilingEntry(A[i]);
            Map.Entry lowerEntry = map.floorEntry(A[i]);

            if (higherEntry != null) {
                higher[i] = lower[(int) higherEntry.getValue()];
            }

            if (lowerEntry != null) {
                lower[i] = higher[(int) lowerEntry.getValue()];
            }

            if (higher[i]) {
                goodStartingIndexCount++;
            }

            map.put(A[i], i);
        }

        return goodStartingIndexCount;
    }
}
