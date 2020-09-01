package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private Set<Integer> set = new HashSet<Integer>();

    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        set.add(val);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
