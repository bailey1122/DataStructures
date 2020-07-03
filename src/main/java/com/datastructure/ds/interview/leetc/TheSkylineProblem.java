package com.datastructure.ds.interview.leetc;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(5);
        q.add(2);
        q.add(5);

        q.remove(5);

        System.out.println(q);
    }
}
