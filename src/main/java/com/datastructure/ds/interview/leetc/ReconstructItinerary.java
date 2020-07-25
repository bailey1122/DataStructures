package com.datastructure.ds.interview.leetc;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<String, Queue<String>>();

        // in the case when the specified key is not associated with a value (or is mapped to null), it creates
        // new PriorityQueue. In any case it adds the new value ticket.get(1)
        for (List<String> t : tickets) {
            map.computeIfAbsent(t.get(0),
                    k -> new PriorityQueue<String>()).add(t.get(1));
        }

        Stack<String> stack = new Stack<String>();
        stack.push("JFK");

        List<String> res = new ArrayList<String>();

        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) &&
                    !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }

            res.add(0, stack.pop());
        }

        return res;
    }
}
