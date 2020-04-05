package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC: O(N)
// SC: O(N)
public class UnivaluedBinaryTree2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> values;

    public boolean isUnivalTree(TreeNode root) {
        values = new ArrayList<Integer>();
        dfs(root);
        for (int v : values) {
            if (v != values.get(0)) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        values.add(root.val);

        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }
}
