package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                if (i == 0) {
                    res.add(currentNode.val);
                } else {
                    int prevPos = res.size() - 1;
                    int prevEl = res.get(prevPos);

                    res.set(prevPos, Math.max(prevEl, currentNode.val));
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }

        return res;
    }

    public List<Integer> largestValues2v(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;

        if (level == res.size()) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }

        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }
}
