package com.datastructure.ds.interview.leetc;

import java.util.Stack;

class MinStack extends Stack<Integer> {
    Stack<Integer> s1;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<Integer>();
    }

    public void push(int x) {
        if (x <= getMin()) {
            s1.push(x);
        }
        super.push(x);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == getMin()) {
            s1.pop();
        }
        return value;
    }

    public int top() {
        return super.peek();
    }

    public int getMin() {
        if (s1.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s1.peek();
        }
    }
}