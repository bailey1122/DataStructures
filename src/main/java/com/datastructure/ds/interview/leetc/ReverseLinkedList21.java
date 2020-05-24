package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC:
public class ReverseLinkedList21 {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode currNode = head;

        while (m > 1) {
            prev = currNode;
            currNode = currNode.next;
            m--;
            n--;
        }

        ListNode beforeReverse = prev;
        ListNode tail = currNode;

        while (n > 0) {
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
            n--;
        }

        if (beforeReverse != null) {
            beforeReverse.next = prev;
        } else {
            head = prev;
        }

        tail.next = currNode;

        return head;
    }
}
