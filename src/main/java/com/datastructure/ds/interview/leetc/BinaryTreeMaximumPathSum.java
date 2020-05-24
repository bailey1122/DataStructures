package com.datastructure.ds.interview.leetc;

public class BinaryTreeMaximumPathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int maxPathSumValue;

    public int maxPathSum(TreeNode root) {
        maxPathSumValue = Integer.MIN_VALUE;
        maxPath(root);

        return maxPathSumValue;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        maxPathSumValue = Math.max(maxPathSumValue, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
