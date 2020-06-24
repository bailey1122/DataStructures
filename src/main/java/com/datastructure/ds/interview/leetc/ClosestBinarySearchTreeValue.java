package com.datastructure.ds.interview.leetc;

public class ClosestBinarySearchTreeValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    private int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }

        return res;
    }
}
