package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(N)
public class DiameterOfBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int count;

    public int diameterOfBinaryTree(TreeNode root) {
        count = 1;
        depth(root);
        return count - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        count = Math.max(count, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
