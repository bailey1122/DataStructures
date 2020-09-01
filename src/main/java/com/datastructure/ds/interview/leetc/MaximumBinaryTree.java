package com.datastructure.ds.interview.leetc;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> d = new LinkedList<TreeNode>();

        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);

            while (!d.isEmpty() && d.peek().val < nums[i]) {
                curr.left = d.pop();
            }

            if (!d.isEmpty()) {
                d.peek().right = curr;
            }

            d.push(curr);
        }

        return d.isEmpty() ? null : d.removeLast();
    }
}
