package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(H), where H is the height of the tree
public class BinaryTreePruning {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        containsOne(root);
        return root;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
        boolean contLeft = containsOne(root.left);
        boolean contRight = containsOne(root.right);
        if (!contLeft) root.left = null;
        if (!contRight) root.right = null;
        return root.val == 1 || contLeft || contRight;
    }
}
