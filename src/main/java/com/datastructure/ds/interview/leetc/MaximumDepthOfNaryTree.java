package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNaryTree {

    private class Node {
        public int val;
        public List<Node> children;

        public Node(int x) {
            val = x;
        }

        public Node(int x, List<Node> c) {
            val = x;
            children = c;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                for (Node child : currNode.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }

        return depth;
    }


    int maxDepth = 0;
    public int maxDepth2(Node root) {
        maxDepth = 0;
        if (root == null) return 0;
        getMaxDepth(root, 1);

        return maxDepth;
    }

    private void getMaxDepth(Node root, int depth) {
        if (root == null) return;
        maxDepth = Math.max(maxDepth, depth);
        for (Node child : root.children) {
            getMaxDepth(child, depth + 1);
        }
    }
}
