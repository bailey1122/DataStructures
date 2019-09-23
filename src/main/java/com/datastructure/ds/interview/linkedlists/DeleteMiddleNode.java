package com.datastructure.ds.interview.linkedlists;

public class DeleteMiddleNode {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
