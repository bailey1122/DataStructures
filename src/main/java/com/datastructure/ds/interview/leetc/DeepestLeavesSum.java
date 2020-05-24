package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        int sumLeaves = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            sumLeaves = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                sumLeaves += currNode.val;

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }

        return sumLeaves;
    }
}
