package com.datastructure.ds.interview.leetc;


import java.util.Stack;

public class KthSmallestElementInABST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int count;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = 0;

        dfs(root, k);

        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left, k);
        count++;

        if (count == k) {
            ans = root.val;

            return;
        }

        dfs(root.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode curr = stack.pop();
            k--;

            if (k == 0) return curr.val;

            TreeNode rightN = curr.right;

            while (rightN != null) {
                stack.push(rightN);
                rightN = rightN.left;
            }
        }

        return -1;
    }
}
