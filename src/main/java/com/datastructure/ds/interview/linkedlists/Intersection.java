package com.datastructure.ds.interview.linkedlists;

import com.datastructure.ds.interview.impl.LinkedListNode;

// O(A+B) time, where A and B are the lengths of the two linked lists
public class Intersection {

    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) return null;

        // get tail and sizes
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        // if different tail nodes, then there's no intersection
        if (result1.tail != result2.tail) {
            return null;
        }

        // set pointers to the start of each linked list
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result1.size ? list2 : list1;

        // advance the pointer for the longer linked list by difference in lengths
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        // move both pointers until you have a collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}

