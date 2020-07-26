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
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            if (!stack.isEmpty()) {
                System.out.println("stack.peek() : " + stack.peek().val);
            }
            System.out.println("inorder[ip] : " + inorder[ip]);
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
                System.out.println(prev.val);
                System.out.println("ip : " + ip);
            }

            System.out.println("postorder[pp] : " + postorder[pp]);
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
                System.out.println("prev.left.val : " + prev.left.val);
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                System.out.println("currTop.val : " + currTop.val);
                currTop.right = newNode;
                System.out.println("currTop.right.val : " + currTop.right.val);
            }
            stack.push(newNode);
            prev = null;
            pp--;
            System.out.println("pp : " + pp);
            System.out.println();
        }

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal c =
                new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        c.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
