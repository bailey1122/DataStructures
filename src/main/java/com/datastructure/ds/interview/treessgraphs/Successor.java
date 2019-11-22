package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

public class Successor {

    TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}