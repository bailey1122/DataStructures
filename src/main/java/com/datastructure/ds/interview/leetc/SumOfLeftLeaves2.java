package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class SumOfLeftLeaves2 {

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

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            if (currNode.left != null) {
                if (currNode.left.left == null && currNode.left.right == null) {
                    sum += currNode.left.val;
                } else {
                    stack.push(currNode.left);
                }
            }

            if (currNode.right != null) {
                if (currNode.right.left != null || currNode.right.right != null) {
                    stack.push(currNode.right);
                }
            }
        }

        return sum;
    }
}
