package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = new HashSet<Integer>(map.values());

        return set.size() == map.size();
    }
}
