package com.datastructure.ds.interview.leetc;

public class CountGoodNodesInBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int goodNodes(TreeNode root) {

        return dfs(root, -10000);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        int res = root.val >= max ? 1 : 0;
        res += dfs(root.left, Math.max(root.val, max));
        res += dfs(root.right, Math.max(root.val, max));

        return res;
    }
}
