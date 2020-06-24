package com.datastructure.ds.interview.leetc;

// TC: O(h) or O(n)
public class CountCompleteTreeNodes {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightL = 0, heightR = 0;
        TreeNode leftS = root, rightS = root;

        while (leftS != null) {
            heightL++;
            leftS = leftS.left;
        }
        while (rightS != null) {
            heightR++;
            rightS = rightS.right;
        }

        if (heightL == heightR) {
            return (int) Math.pow(2, heightL) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
