package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {

    private class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int x) {
            val = x;
        }

        public Node(int x, List<Node> c) {
            val = x;
            children = c;
        }
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;

        LinkedList<Node> stack = new LinkedList<Node>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pollLast();
            res.addFirst(currentNode.val);
            for (Node child : currentNode.children) {
                stack.add(child);
            }
        }

        return res;
    }
}
