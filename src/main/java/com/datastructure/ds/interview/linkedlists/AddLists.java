package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

public class AddLists {

    LinkedListNode addLists1(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10; // second digit of number

        // recurse
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists1(l1 == null ? null : l1.next,
                                            l2 == null ? null : l2.next,
                                            value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }
}
