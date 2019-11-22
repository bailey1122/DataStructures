package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

// O(n) space
public class ReturnKthToLast {

    int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + " th to last node is " + head.data);
        }
        return index;
    }
}
