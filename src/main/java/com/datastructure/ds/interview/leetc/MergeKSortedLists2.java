package com.datastructure.ds.interview.leetc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists2 {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue(cmp);

        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!pq.isEmpty()) {
            point.next = pq.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                pq.add(next);
            }
        }
        return head.next;
    }
}
