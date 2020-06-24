package com.datastructure.ds.interview.leetc;

public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftS = lowestCommonAncestor(root.left, p, q);
        TreeNode rightS = lowestCommonAncestor(root.right, p, q);

        if (leftS != null && rightS != null) {
            return root;
        }

        return leftS != null ? leftS : rightS;
    }
}
