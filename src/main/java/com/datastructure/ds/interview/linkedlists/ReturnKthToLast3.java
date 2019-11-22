package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

// O(n) time and O(1) space
public class ReturnKthToLast3 {

    LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // out of bounds
            p1 = p1.next;
        }

        // move them at the same pace. When p1 hits the end, p2 will be at the right element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
