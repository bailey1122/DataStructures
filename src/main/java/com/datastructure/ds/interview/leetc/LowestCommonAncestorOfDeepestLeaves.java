package com.datastructure.ds.interview.leetc;

public class LowestCommonAncestorOfDeepestLeaves {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    private int maxDepth;
    private TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;

        dfs(root, 0);

        return lca;
    }

    private int dfs(TreeNode root, int currD) {
        maxDepth = Math.max(maxDepth, currD);

        if (root == null) return currD;

        int left = dfs(root.left, currD + 1);
        int right = dfs(root.right, currD + 1);

        if (left == maxDepth && right == maxDepth) {
            lca = root;
        }

        return Math.max(left, right);
    }
}
