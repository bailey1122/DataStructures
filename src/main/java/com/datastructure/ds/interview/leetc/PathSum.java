package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class PathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();

        nodeStack.push(root);
        sumStack.push(sum - root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            if (currentNode.left == null && currentNode.right == null && currentSum == 0) {
                return true;
            }

            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum - currentNode.left.val);
            }

            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum - currentNode.right.val);
            }
        }

        return false;
    }
}
