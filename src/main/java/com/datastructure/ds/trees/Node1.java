package com.datastructure.ds.trees;

public class Node1 {
    public static void main(String[] args) {
        Node1 node1 = new Node1(10);
        node1.insert(5);
        node1.insert(15);
        node1.insert(8);
        node1.printInOrder();
    }

    Node1 left, right;
    int data;

    public Node1(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node1(value);
            } else left.insert(value);
        } else {
            if (right == null) {
                right = new Node1(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        }
        else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }
}







