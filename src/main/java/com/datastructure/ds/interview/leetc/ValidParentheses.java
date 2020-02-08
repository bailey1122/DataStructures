package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

// TC: O(n) because we simply traverse the given string one character
// at a time and push and pop operations on a stack take O(1)O(1)
// time. SC: O(n)as we push all opening brackets onto the stack and
// in the worst case, we will end up pushing all the brackets onto
// the stack. e.g. ((((((((((
public class ValidParentheses {

    private HashMap<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
        this.mappings.put(')', '(');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {

                char topStack = stack.isEmpty() ? '#' : stack.pop();

                if (topStack != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}