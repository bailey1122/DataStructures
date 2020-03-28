package com.datastructure.ds.interview.leetc;

import java.util.Stack;

// TC: O(M + N), where M, N are the lengths of S and T respectively
// SC: O(M + N)
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : str.toCharArray()) {
            if (c != '#')
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }

        return String.valueOf(stack);
    }
}
