package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class AddTwoNumbers2 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stackL1 = new Stack<Integer>();
        Stack<Integer> stackL2 = new Stack<Integer>();

        while (l1 != null) {
            stackL1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stackL2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = new ListNode(0);
        int sum = 0;

        while (!stackL1.isEmpty() || !stackL2.isEmpty()) {
            if (!stackL1.isEmpty()) {
                sum += stackL1.pop();
            }
            if (!stackL2.isEmpty()) {
                sum += stackL2.pop();
            }

            res.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);

            head.next = res;
            res = head;
        }

        return res.val == 0 ? res.next : res;
    }
}
