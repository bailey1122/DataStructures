package com.datastructure.ds.interview.leetc;

public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd,
                            int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode currNode = new TreeNode(preorder[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (currNode.val == inorder[i]) {
                index = i;
            }
        }

        currNode.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        currNode.right = helper(preStart + index - inStart + 1, index + 1, inEnd,
                preorder, inorder);

        return currNode;
    }
}
