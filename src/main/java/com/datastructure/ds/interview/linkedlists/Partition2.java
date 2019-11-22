package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

public class Partition2 {

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
