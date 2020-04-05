package com.datastructure.ds.interview.leetc;

// TC: O(n), where n is the total number of nodes in the linked list.
// Case 1: List has no cycle O(n).
// Case 2: List has a cycle O(N + K), which is O(n)
// SC: O(1)
public class LinkedListCycle {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        if (fast == null || fast.next == null) return false;

        return false;
    }

}
