package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        if (root == null) return res;

        String currPath = Integer.toString(root.val);

        if (root.left == null && root.right == null) {
            res.add(currPath);
        }

        if (root.left != null) dfs(res, root.left, currPath);
        if (root.right != null) dfs(res, root.right, currPath);

        return res;
    }

    private void dfs(List<String> res, TreeNode root, String currPath) {
        currPath += "->" + root.val;

        if (root.left == null && root.right == null) {
            res.add(currPath);
            return;
        }

        if (root.left != null) dfs(res, root.left, currPath);
        if (root.right != null) dfs(res, root.right, currPath);
    }
}
