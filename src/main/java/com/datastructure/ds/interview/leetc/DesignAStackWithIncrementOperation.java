package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class DesignAStackWithIncrementOperation {

    private int v, arr[];
    private Stack<Integer> stack;

    public DesignAStackWithIncrementOperation(int maxSize) {
        this.v = maxSize;
        this.arr = new int[v];
        this.stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.size() < v) stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0) return -1;
        if (i > 0) {
            arr[i - 1] += arr[i];
        }
        int res = stack.pop() + arr[i];
        arr[i] = 0;

        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0) arr[i] += val;
    }
}
