package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(H)
public class DistributeCoinsInBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    int numMoves;

    public int distributeCoins(TreeNode root) {
        numMoves = 0;
        getMoves(root);
        return numMoves;
    }

    private int getMoves(TreeNode root) {
        if (root == null) return 0;
        int left = getMoves(root.left);
        int right = getMoves(root.right);
        numMoves += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
