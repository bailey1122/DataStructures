package com.datastructure.ds.interview.linkedlists;

import java.util.HashSet;

// O(N) time, where N is the number of elements in the linked list
public class DeleteDups {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    void deleteDups1(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
            }
            n = n.next;
        }
    }
}
