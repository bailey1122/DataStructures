package com.datastructure.ds.interview.leetc;

// TC: O(nlogn)
// SC: O(1)
public class SortList {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        return merge(leftSide, rightSide);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
            curr = curr.next;
        }

        if (l2 != null) {
            curr.next = l2;
            curr = curr.next;
        }

        return temp.next;
    }
}
