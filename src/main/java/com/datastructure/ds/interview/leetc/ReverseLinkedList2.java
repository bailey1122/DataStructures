package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class ReverseLinkedList2 {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
