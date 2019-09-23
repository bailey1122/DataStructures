package com.datastructure.ds.interview.linkedlists;

// O(n) space
class Index {
    public int value = 0;
}

public class ReturnKthToLast2 {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
        if (head == null) {
            return null;
        }

        LinkedListNode node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;

        if (idx.value == k) {
            return head;
        }
        return node;
    }
}
