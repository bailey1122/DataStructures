package com.datastructure.ds.interview.linkedlists;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class AddLists2 {

    protected class LinkedListNode {
        private int data;
        private LinkedListNode next;

        public LinkedListNode() {
        }

        public LinkedListNode(int data) {
            this.data = data;
        }
    }


    LinkedListNode addLists22(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // pad the shorter list with zeros
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        // add lists
        PartialSum sum = addListsHelper(l1, l2);

        // if there was a carry value left over, insert this at the front of the list.
        // Otherwise, just return the linked list
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode res = insertBefore(sum.sum, sum.carry);
            return res;
        }
    }

    PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);
        // add carry to current data
        int val = sum.carry + l1.data + l2.data;

        // insert sum of current digits
        LinkedListNode result = insertBefore(sum.sum, val % 10);

        // return sum so far, and the carry value
        sum.sum = result;
        sum.carry = val / 10;
        return sum;
    }

    // pad the list with zeros
    LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    // insert node in the front of a linked list
    LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }
}

class PartialSum {
    AddLists2.LinkedListNode sum = null;
    int carry = 0;
}













