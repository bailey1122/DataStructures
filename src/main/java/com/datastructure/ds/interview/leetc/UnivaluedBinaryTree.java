package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(H)
public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        boolean leftUnivalued = root.left == null
                || root.val == root.left.val && isUnivalTree(root.left);

        boolean rightUnivalued = root.right == null
                || root.val == root.right.val && isUnivalTree(root.right);

        return leftUnivalued && rightUnivalued;
    }
}
