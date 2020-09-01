package com.datastructure.ds.interview.leetc;

public class InsertIntoABinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true) {
            if (curr.val > val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
