package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan {

    private Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<int[]>();
    }

    public int next(int price) {
        int res = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }

        stack.push(new int[]{price, res});

        return res;
    }
}
