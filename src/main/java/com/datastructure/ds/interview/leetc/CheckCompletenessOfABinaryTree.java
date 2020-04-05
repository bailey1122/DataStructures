package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }


    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                end = true;
            } else {
                if (end) return false;
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }

        return true;
    }
}
