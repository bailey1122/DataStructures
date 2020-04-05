package com.datastructure.ds.interview.leetc;

import java.util.Stack;

// TC: O(N), where N is the length of S
// SC: O(N)
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
