package com.datastructure.ds.interview.leetc;

import java.util.*;

// TC: O(N(log(k))
// SC: O(N)
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (a, b) -> map.get(a) - map.get(b));
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        while (!heap.isEmpty())
            result.add(heap.poll());
        Collections.reverse(result);
        return result;
    }
}
