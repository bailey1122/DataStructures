package com.datastructure.ds.interview.leetc;

public class RemoveLinkedListElement {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode currNode = dummy;

        while (currNode.next != null) {
            if (currNode.next.val == val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }

        return dummy.next;
    }
}
