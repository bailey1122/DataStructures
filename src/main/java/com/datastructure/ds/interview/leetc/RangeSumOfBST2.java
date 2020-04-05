package com.datastructure.ds.interview.leetc;

import java.util.Stack;

// TC: O(N)
// SC: O(H)
public class RangeSumOfBST2 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int rangeSum = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if (currNode != null) {
                if (currNode.val >= L && currNode.val <= R) {
                    rangeSum += currNode.val;
                }

                if (currNode.left != null && currNode.val > L) {
                    stack.push(currNode.left);
                }
                if (currNode.right != null && currNode.val < R) {
                    stack.push(currNode.right);
                }
            }
        }

        return rangeSum;
    }
}
