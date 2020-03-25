package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Stack<TreeNode> s1 = new Stack<TreeNode>(); // left to right
        Stack<TreeNode> s2 = new Stack<TreeNode>(); // right to left

        s1.push(root);

        List<Integer> list = new ArrayList<Integer>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode currentNode = s1.pop();
                list.add(currentNode.val);
                if (currentNode.left != null) {
                    s2.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    s2.push(currentNode.right);
                }
            }
            if (!list.isEmpty())
                res.add(new ArrayList<Integer>(list));
            list.clear();

            while (!s2.isEmpty()) {
                TreeNode currentNode = s2.pop();
                list.add(currentNode.val);
                if (currentNode.right != null) {
                    s1.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    s1.push(currentNode.left);
                }
            }
            if (!list.isEmpty())
                res.add(new ArrayList<Integer>(list));
            list.clear();
        }

        return res;
    }
}
