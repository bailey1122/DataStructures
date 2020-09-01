package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class BinarySearchTreeToGreaterSumTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    private int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);

        return root;
    }

    public TreeNode bstToGst2(TreeNode root) {
        int sum = 0;

        TreeNode curr = root;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }

        return root;
    }
}
