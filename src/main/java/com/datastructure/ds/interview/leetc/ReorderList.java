package com.datastructure.ds.interview.leetc;

public class ReorderList {

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode l1 = head;
        ListNode prev = null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);
        merge(l1, l2);

    }

    private ListNode reverse(ListNode head) {
        ListNode currNode = head;
        ListNode prev = null;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;

            if (l1Next == null) {
                break;
            }

            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
