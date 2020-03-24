package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// TC: O(NlogA), where N is the length of S,
// and A is the size of the alphabet. If A is
// fixed, then it's O(N)
// SC: O(A). If A is fixed, then it's O(1)
public class ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<Character>(
                (a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            char c1 = heap.poll();
            char c2 = heap.poll();

            sb.append(c1);
            sb.append(c2);
            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);

            if (map.get(c1) > 0 ) {
                heap.add(c1);
            }
            if (map.get(c2) > 0) {
                heap.add(c2);
            }
        }

        if (!heap.isEmpty()) {
            char last = heap.poll();
            if (map.get(last) > 1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}
