package com.datastructure.ds.interview.linkedlists;

import java.util.Stack;

public class PalindromeL2 {

    private class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }

    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        // pushes elements from first half of linked list onto stack
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
