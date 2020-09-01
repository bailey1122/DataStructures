package com.datastructure.ds.interview.leetc;

public class SumOfNodesWithEvenValuedGrandparent {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {

        return helper(root, 1, 1);
    }

    private int helper(TreeNode curr, int p, int gp) {
        if (curr == null) return 0;

        return helper(curr.left, curr.val, p) +
                helper(curr.right, curr.val, p)
                + (gp % 2 == 0 ? curr.val : 0);
    }
}
