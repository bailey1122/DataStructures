package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TC: O(n)
public class InOrderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> arr_output = new ArrayList<Integer>();

        if (root == null) {
            return arr_output;
        }

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            arr_output.add(current.val);
            current = current.right;
        }
        return arr_output;
    }
}
