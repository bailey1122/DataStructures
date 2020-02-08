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
        ListNode dumpHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dumpHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dumpHead.next;
    }
}
