package com.datastructure.ds.interview.linkedlists;

// O(N^2) time, O(1) space
public class DeleteDups2 {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    void deleteDups22(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            // remove all future nodes that have the same value
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
