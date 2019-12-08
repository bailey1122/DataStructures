package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

// TC: O(n + m). SC: O(n + m), where n and m are the number of nodes in T1 and T2
public class CheckSubtree {

    boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X"); // null indicator
            return;
        }
        sb.append(node.data + " "); // root
        getOrderString(node.left, sb); // left
        getOrderString(node.right, sb); // right
    }
}