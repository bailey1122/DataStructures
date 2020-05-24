package com.datastructure.ds.interview.leetc;

public class ConvertSortedArrayToBinarySearchTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    private TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) return null;
        int midpoint = left + (right - left) / 2;
        TreeNode currNode = new TreeNode(nums[midpoint]);
        currNode.left = constructTreeFromArray(nums, left, midpoint - 1);
        currNode.right = constructTreeFromArray(nums, midpoint + 1, right);

        return currNode;
    }
}
