package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(N)
public class MiddleOfTheLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
