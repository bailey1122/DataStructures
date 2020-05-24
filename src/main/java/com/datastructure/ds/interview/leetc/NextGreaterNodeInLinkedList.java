package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();

        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
        }

        int[] res = new int[list.size()];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }

        return res;
    }
}
