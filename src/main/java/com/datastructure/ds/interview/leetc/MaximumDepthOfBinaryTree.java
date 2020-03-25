package com.datastructure.ds.interview.leetc;

public class MaximumDepthOfBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        int d = depth(root);
        return d;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);

        return Math.max(L, R) + 1;
    }
}
