package com.datastructure.ds.interview.linkedlists;

public class Partition2 {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                // insert data at head
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // the head has changed, so we need to return it to user
        return head;
    }
}
