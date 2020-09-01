package com.datastructure.ds.interview.leetc;

public class DeleteLeavesWithAGivenValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);

        return root.left == root.right && root.val == target ? null : root;
    }
}
