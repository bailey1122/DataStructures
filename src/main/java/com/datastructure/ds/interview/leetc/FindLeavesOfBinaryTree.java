package com.datastructure.ds.interview.leetc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesOfBinaryTree{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth = -1;
    private Map<Integer, List<Integer>> levels =
            new HashMap<Integer, List<Integer>>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        calculate(root);
        for (int i = 0; i <= maxDepth; i++) {
            res.add(levels.get(i));
        }

        return res;
    }

    private int calculate(TreeNode root) {
        if (root == null) return -1;

        int height = Math.max(calculate(root.left),
                calculate(root.right)) + 1;
        if (levels.containsKey(height)) {
            levels.get(height).add(root.val);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            levels.put(height, list);
        }

        if (height > maxDepth) {
            maxDepth = height;
        }

        return height;
    }
}
