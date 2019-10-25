package com.datastructure.ds.interview.stacksandqueues;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> s1;
    public StackWithMin() {
        s1 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            s1.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s1.pop();
        }
        return value;
    }

    public int min() {
        if (s1.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s1.peek();
        }
    }
}
