package com.datastructure.ds.interview.linkedlists;

// remove all elements from a linked list of integers that have value val
public class RemoveEl {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n = dummy;
        while(n.next != null) {
            if (n.next.val == val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return dummy.next;
    }
}
