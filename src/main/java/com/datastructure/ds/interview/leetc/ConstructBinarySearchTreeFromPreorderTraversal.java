package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        return construct(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode construct(int[] preorder, int bound, int[] pos) {
        if (pos[0] == preorder.length ||
                preorder[pos[0]] > bound) return null;

        TreeNode node = new TreeNode(preorder[pos[0]++]);
        node.left = construct(preorder, node.val, pos);
        node.right = construct(preorder, bound, pos);

        return node;
    }
}
