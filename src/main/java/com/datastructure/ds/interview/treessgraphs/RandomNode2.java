package com.datastructure.ds.interview.treessgraphs;

import java.util.Random;

public class RandomNode2{ }

// TC: O(logN) in a balanced tree. O(D), where D is the max depth of the tree
class Tree {
    TreeNode2 root = null;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode2 getRandomNode(){
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if (root == null) {
            root = new TreeNode2(value);
        } else {
            root.insertInOrder(value);
        }
    }
}

class TreeNode2 {
    private int data;
    public TreeNode2 left;
    public TreeNode2 right;
    private int size = 0;

    public TreeNode2(int d) {
        data = d;
        size = 1;
    }

    public TreeNode2 getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size();
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }

    public int size() {
        return size;
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode2(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode2(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public TreeNode2 find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}

