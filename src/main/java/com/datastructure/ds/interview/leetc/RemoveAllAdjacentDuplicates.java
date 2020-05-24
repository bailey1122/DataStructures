package com.datastructure.ds.interview.leetc;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int i = 0;

        for (int j = 0; j < S.length(); j++) {
            char currChar = S.charAt(j);

            if (i > 0 && currChar == stack[i - 1]) {
                i--;
            } else {
                stack[i] = currChar;
                i++;
            }
        }

        return new String(stack, 0, i);
    }
}
