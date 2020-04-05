package com.datastructure.ds.interview.leetc;

public class SwapNodesInPairs {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;

        while (curr.next != null && curr.next.next != null) {
            ListNode firstNode = curr.next;
            ListNode secondNode = curr.next.next;
            firstNode.next = secondNode.next;
            curr.next = secondNode;
            curr.next.next = firstNode;
            curr = curr.next.next;
        }

        return temp.next;
    }
}