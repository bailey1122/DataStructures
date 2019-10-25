package com.datastructure.ds.interview.stacksandqueues;

import java.util.Stack;

// O(N^2) time. (O) space
public class SortStack {

    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
