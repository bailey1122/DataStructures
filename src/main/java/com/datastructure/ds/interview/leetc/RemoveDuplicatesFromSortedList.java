package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class RemoveDuplicatesFromSortedList {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;

        while (currNode != null && currNode.next != null) {
            if (currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }

        return head;
    }
}
