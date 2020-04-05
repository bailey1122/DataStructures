package com.datastructure.ds.interview.leetc;

// TC: O(max(m, n)). Assume that mm and nn represents the length of l1l1 and
// l2l2 respectively,the algorithm above iterates at most \max(m, n)max(m,n)
// times. SC: O(max(m,n)).The length of the new list is at most \max(m,n) + 1max(m,n)+1
public class AddTwoNumbers {

     private class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;

        ListNode q = l1, p = l2;
        int carry = 0;

        while (q != null || p != null) {
            int x = (q != null) ? q.val : 0;
            int y = (p != null) ? p.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            int lastDigit = sum % 10;

            ListNode node = new ListNode(lastDigit);
            currNode.next = node;
            currNode = currNode.next;

            if (q != null) q = q.next;
            if (p != null) p = p.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            currNode.next = node;
            currNode = currNode.next;
        }

        return dummy.next;
    }
}
