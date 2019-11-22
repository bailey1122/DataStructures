package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

import java.util.Stack;

public class PalindromeL2 {

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
