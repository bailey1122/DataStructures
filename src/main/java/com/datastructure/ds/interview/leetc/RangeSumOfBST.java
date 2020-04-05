package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(H)
public class RangeSumOfBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    int rangeSum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum = 0;
        getRangeSumBST(root, L, R);
        return rangeSum;
    }

    private void getRangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return;

        if (root.val >= L && root.val <= R) {
            rangeSum += root.val;
        }

        if (root.val > L) getRangeSumBST(root.left, L, R);
        if (root. val < R) getRangeSumBST(root.right, L, R);
    }
}
