package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

// TC: O(N)
// SC: O(N)
public class MaximumWidthOfBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    int maxWidth;
    Map<Integer, Integer> map;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<Integer, Integer>();
        getWidthOfBinaryTree(root, 0, 0);
        return maxWidth;
    }

    private void getWidthOfBinaryTree(TreeNode root, int depth, int position) {
        if (root == null) return;
        map.computeIfAbsent(depth, x -> position);
        maxWidth = Math.max(maxWidth, position - map.get(depth) + 1);
        getWidthOfBinaryTree(root.left, depth + 1, position * 2);
        getWidthOfBinaryTree(root.right, depth + 1, position * 2 + 1);
    }
}