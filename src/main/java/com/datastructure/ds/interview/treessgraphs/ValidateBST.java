package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

public class ValidateBST{

    Integer lastPrinted = null;
    boolean checkBST(TreeNode n) {
        if (n == null) return true;

        if (!checkBST(n.left)) return false;

        if (lastPrinted != null && n.data <= lastPrinted) {
            return false;
        }
        lastPrinted = n.data;

        if (!checkBST(n.right)) return false;

        return true;
    }
}