package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private Set<Integer> set;
    private List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<Integer>();
        res = new ArrayList<TreeNode>();

        for (int i : to_delete) {
            set.add(i);
        }

        dfs(root, true);

        return res;
    }

    private TreeNode dfs(TreeNode root, boolean isRoot) {
        if (root == null) return null;

        boolean deleted = set.contains(root.val);

        if (isRoot && !deleted) res.add(root);

        root.left = dfs(root.left, deleted);
        root.right = dfs(root.right, deleted);

        return deleted ? null : root;
    }
}
