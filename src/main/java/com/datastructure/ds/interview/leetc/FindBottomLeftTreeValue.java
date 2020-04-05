package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }

        return root.val;
    }
}
