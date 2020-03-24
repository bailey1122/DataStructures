package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String t : tokens) {
            if ("+-*/".contains(t)) {
                int y = stack.pop();
                int x = stack.pop();

                if (t.equals("+"))
                    stack.push(x + y);
                else if (t.equals("-"))
                    stack.push(x - y);
                else if (t.equals("*"))
                    stack.push(x * y);
                else if (t.equals("/"))
                    stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
