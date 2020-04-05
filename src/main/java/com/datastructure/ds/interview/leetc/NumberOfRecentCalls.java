package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

// TC: Q(Q), where Q is the number of queries made
// SC: O(1). Also, it's O(W), where W = 3000 is the size of the window we should
// scan for recent calls.
public class NumberOfRecentCalls {

    class RecentCounter {

        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<Integer>();
        }

        public int ping(int t) {
            queue.offer(t);

            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }
}
