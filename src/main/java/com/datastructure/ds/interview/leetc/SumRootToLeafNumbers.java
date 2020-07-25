package com.datastructure.ds.interview.leetc;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        int total = 0;

        Queue<TreeNode> nq = new LinkedList<TreeNode>();
        Queue<Integer> vq = new LinkedList<Integer>();

        if (root != null) {
            nq.offer(root);
            vq.offer(root.val);
        }

        while (!nq.isEmpty()) {
            TreeNode curr = nq.poll();
            int currSum = vq.poll();

            if (curr.left == null && curr.right == null) {
                total += currSum;
            } else {
                if (curr.left != null) {
                    nq.offer(curr.left);
                    vq.offer(currSum * 10 + curr.left.val);
                }
                if (curr.right != null) {
                    nq.offer(curr.right);
                    vq.offer(currSum * 10 + curr.right.val);
                }
            }
        }

        return total;
    }
}
