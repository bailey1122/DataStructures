package com.datastructure.ds.interview.leetc;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) return cloned;

        TreeNode curr = getTargetCopy(original.left, cloned.left, target);
        if (curr != null) {
            return curr;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }
}
