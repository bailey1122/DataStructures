package com.datastructure.ds.interview.leetc;

public class IncreasingOrderSearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode next) {
        if (root == null) return next;

        TreeNode res = helper(root.left, root);
        root.left = null;

        root.right = helper(root.right, next);

        return res;
    }
}
