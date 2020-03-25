package com.datastructure.ds.interview.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighestScore {

    public String find(Map<String, Integer> map) {
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(
                                    (a, b) -> map.get(b) - map.get(a));
        for (String k : map.keySet()) {
            maxHeap.add(k);
        }

        return maxHeap.poll();
    }

    public static void main(String[] args) {
        HighestScore hs = new HighestScore();

        Map<String, Integer> map = new HashMap<>();
        map.put("Jake", 2);
        map.put("Lana", 10);
        map.put("David", 15);
        map.put("Mia", 1);

        System.out.println(hs.find(map));
    }
}
