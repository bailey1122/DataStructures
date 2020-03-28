package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;

public class ValidateBinarySearchTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }



    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    private boolean isValidBST2(long min, long max, TreeNode head) {
        if (head == null) return true;

        if (head.val <= min || head.val >= max) return false;

        return isValidBST2(min, head.val, head.left) &&
                isValidBST2(head.val, max, head.right);
    }



    // TC: O(N)
    // SC: O(N)
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    LinkedList<Integer> lowers = new LinkedList<Integer>();
    LinkedList<Integer> uppers = new LinkedList<Integer>();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST3(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.pollLast();
            lower = lowers.pollLast();
            upper = uppers.pollLast();

            if (root == null) continue;
            val = root.val;
            if (upper != null && val >= upper) return false;
            if (lower != null && val <= lower) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }
}