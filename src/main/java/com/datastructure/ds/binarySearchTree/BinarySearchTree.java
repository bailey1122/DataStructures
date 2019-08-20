package com.datastructure.ds.binarySearchTree;

public class BinarySearchTree {
    boolean checkBST(Node2 root, int min, int max) { // inclusive ranges
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);
    }

    boolean checkBST(Node2 root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

class Node2 {
    int data;
    Node2 left;
    Node2 right;
}


