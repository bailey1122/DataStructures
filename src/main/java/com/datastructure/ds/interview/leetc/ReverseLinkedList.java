package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(n)
public class ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
