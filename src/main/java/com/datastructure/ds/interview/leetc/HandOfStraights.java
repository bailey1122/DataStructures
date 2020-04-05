package com.datastructure.ds.interview.leetc;

import java.util.TreeMap;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int n : hand) {
//            map.put(n, map.getOrDefault(n, 0) + 1);
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.replace(n, map.get(n) + 1);
            }
        }

        while (map.size() > 0) {
            int firstKey = map.firstKey();
            for (int i = firstKey; i < firstKey + W; i++) {
                if (!map.containsKey(i)) return false;
                int count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.replace(i, map.get(i) - 1);
                }
            }
        }

        return true;
    }
}
