package com.datastructure.ds.interview.leetc;

// TC: O(1)
// SC: O(1)
public class DeleteNodeInALinkedList {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
