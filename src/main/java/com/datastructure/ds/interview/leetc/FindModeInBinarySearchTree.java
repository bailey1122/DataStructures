package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    Integer prev;
    int count;
    int max;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        prev = null;
        count = 1;
        max = 0;

        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traverse(root.left, list);

        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }

        prev = root.val;

        traverse(root.right, list);
    }
}
