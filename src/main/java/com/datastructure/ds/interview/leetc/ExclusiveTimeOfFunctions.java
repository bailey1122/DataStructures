package com.datastructure.ds.interview.leetc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// TC: O(n)
// SC: the stack can grow upto a depth of at most n/2,
// where n is the number of elements in logs
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] res = new int[n];
        int prev = 0;
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        prev = Integer.parseInt(s[2]);

        for (int i = 1; i < logs.size(); i++) {
            s = logs.get(i).split(":");

            int func = Integer.parseInt(s[0]);
            int time = Integer.parseInt(s[2]);

            if (s[1].equals("start")) {
                if (!stack.isEmpty()) res[stack.peek()] += time - prev;
                stack.push(func);
                prev = time;
            } else {
                res[stack.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return res;
    }
}
