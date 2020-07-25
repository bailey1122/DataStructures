package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> q =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (a, b) -> b.getValue() - a.getValue());
        q.addAll(map.entrySet());

        StringBuilder res = new StringBuilder(s.length());

        while (!q.isEmpty()) {
            Map.Entry<Character, Integer> curr = q.poll();

            for (int i = 0; i < (int) curr.getValue(); i++) {
                res.append(curr.getKey());
            }
        }

        return res.toString();
    }
}
