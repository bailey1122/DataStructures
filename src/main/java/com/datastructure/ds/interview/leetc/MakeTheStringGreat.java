package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()
                    && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();

            } else {
                stack.push(s.charAt(i));
            }
        }

        char[] arr = new char[stack.size()];
        int pos = stack.size() - 1;
        while (!stack.isEmpty()) arr[pos--] = stack.pop();

        return new String(arr);
    }
}
