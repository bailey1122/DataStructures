package com.datastructure.ds.interview.leetc;

public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                sum += sumOfLeftLeaves(root.right);
            }
        }

        return sum;
    }
}
