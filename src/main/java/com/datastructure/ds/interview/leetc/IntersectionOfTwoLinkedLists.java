package com.datastructure.ds.interview.leetc;

// TC: (m+n)
// SC: O(1)
public class IntersectionOfTwoLinkedLists {

    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode aPointer = headA;
        ListNode bPointer = headB;

        while (aPointer != bPointer) {

            if (aPointer == null) {
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }

            if (bPointer == null) {
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }

        return aPointer;
    }
}
