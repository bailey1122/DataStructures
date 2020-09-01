package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null ||
                postorder.length == 0) {
            return null;
        }

        int ip = inorder.length - 1, pp = postorder.length - 1;

        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp--]);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (pp >= 0) {
            while (!stack.isEmpty() && inorder[ip] == stack.peek().val) {
                prev = stack.pop();
                ip--;
            }

            TreeNode curr = new TreeNode(postorder[pp]);

            if (prev != null) {
                prev.left = curr;
            } else {
                TreeNode top = stack.peek();
                top.right = curr;
            }

            stack.push(curr);
            prev = null;
            pp--;
        }

        return root;
    }
}
