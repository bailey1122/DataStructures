package com.datastructure.ds.interview.leetc;

public class ConvertBinaryNumberInALinkedListToInteger {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }

        return res;
    }
}
