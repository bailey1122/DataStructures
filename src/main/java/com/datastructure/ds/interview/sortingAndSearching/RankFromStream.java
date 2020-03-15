package com.datastructure.ds.interview.sortingAndSearching;

public class RankFromStream {
    RankNode root = null;

    void track(int d) {
        if (root == null) {
            root = new RankNode(d);
        } else {
            root.insert(d);
        }
    }

    int getRankOfNumber(int d) {
        return root.getRank(d);
    }
}

class RankNode {
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;

    public RankNode(int d) {
        data = d;
    }

    void insert(int d) {
        if (d <= data) {
            if (left != null) left.insert(d);
            else left = new RankNode(d);
            left_size++;
        } else {
            if (right != null) right.insert(d);
            else right = new RankNode(d);
        }
    }

    int getRank(int number) {
        if (data == number) {
            return left_size;
        } else if (number < data) {
            if (left == null) return - 1;
            else return left.getRank(number);
        } else {
            int right_rank = right == null ? -1 : right.getRank(number);
            if (right_rank == -1) return -1;
            else return left_size + 1 + right_rank;
        }
    }
}
