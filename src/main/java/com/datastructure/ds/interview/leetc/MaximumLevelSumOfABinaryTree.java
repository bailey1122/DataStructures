package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, maxLevel = 1;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                sum += curr.val;

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }



    public int maxLevelSum2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        dfs(root, res, 0);

        int maxLevel = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(maxLevel) < res.get(i)) {
                maxLevel = i;
            }
        }

        return maxLevel + 1;
    }

    private void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, res.get(level) + node.val);
        }

        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}
