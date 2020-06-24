package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    // iteratively
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop();
                curr = curr.right;
            } else {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
        }

        return res;
    }

    // recursively
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        TreeNode curr = root;
        pot(curr, res);

        return res;
    }

    private void pot(TreeNode curr, List<Integer> res) {
        if (curr == null) return;

        res.add(curr.val);
        pot(curr.left, res);
        pot(curr.right, res);
    }
}
