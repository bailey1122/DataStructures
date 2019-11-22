package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

// TC: O(N). SC: O(log N) on a balanced tree
public class ValidateBST2 {

    boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }

        return true;
    }
}
