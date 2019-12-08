package com.datastructure.ds.interview.treessgraphs;

import java.util.Random;

// TC: in a balanced tree O(logN), where N is the number of nodes
public class RandomNode {

    private int data; // private
    public RandomNode left;
    public RandomNode right;
    private int size = 0; // private

    public RandomNode(int d) {
        data = d;
        size = 1;
    }


    public RandomNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size;
        Random random = new Random();
        int index = random.nextInt(size);
        if (index <= leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new RandomNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new RandomNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }

    public RandomNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d >= data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}
