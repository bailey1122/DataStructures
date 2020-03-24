package com.datastructure.ds.interview.leetc;

public class PopulatingNextRightPointersInEachNode {

    private class Node {
        Node left;
        Node right;
        Node next;
        int val;

        public Node() {
        }

        public Node(int x) {
            val = x;
        }
    }

    public Node connect(Node root) {
        Node lowerLeft = root;
        while (lowerLeft != null && lowerLeft.left != null) {
            populateLowerLevel(lowerLeft);
            lowerLeft = lowerLeft.left;
        }
        return root;
    }

    private void populateLowerLevel(Node startNode) {
        Node iter = startNode;
        while (iter != null) {
            iter.left.next = iter.right;
            if (iter.next != null)
                iter.right.next = iter.next.left;
            iter = iter.next;
        }
    }
}
