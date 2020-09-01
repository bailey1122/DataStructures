package com.datastructure.ds.interview.leetc;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<Integer>(),
                q2 = new LinkedList<Integer>();

        helper(root1, q1);
        helper(root2, q2);

        List<Integer> res = new ArrayList<Integer>();

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q2.isEmpty()) {
                res.add(q1.poll());
            } else if (q1.isEmpty()) {
                res.add(q2.poll());
            } else {
                res.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
            }
        }

        return res;
    }

    private void helper(TreeNode root, Queue<Integer> q) {
        if (root == null) return;
        helper(root.left, q);
        q.offer(root.val);
        helper(root.right, q);
    }

    private void helper2(TreeNode root, Queue<Integer> q) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return;

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            q.offer(curr.val);
            curr = curr.right;
        }
    }
}
