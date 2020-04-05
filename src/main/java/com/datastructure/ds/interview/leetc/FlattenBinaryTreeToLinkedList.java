package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }


    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);

            if (!stack.isEmpty()) {
                currNode.right = stack.peek();
            }

            currNode.left = null;
        }
    }
}
