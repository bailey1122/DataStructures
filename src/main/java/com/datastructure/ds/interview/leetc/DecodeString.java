package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> stackCount = new Stack<Integer>();
        Stack<String> stackResult = new Stack<String>();

        int index = 0;

        StringBuilder res = new StringBuilder();

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;

                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }

                stackCount.push(count);
            } else if (s.charAt(index) == '[') {
                stackResult.push(res.toString());
                res.delete(0, res.length());
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder tempSb;
                if (!stackResult.isEmpty()) {
                    tempSb = new StringBuilder(stackResult.pop());
                } else {
                    tempSb = new StringBuilder();
                }

                int count = 0;
                if (!stackCount.isEmpty()) {
                    count = stackCount.pop();
                }

                for (int i = 0; i < count; i++) {
                    tempSb.append(res.toString());
                }

                res.delete(0, res.length());
                res.append(tempSb);
                index++;
            } else {
                res.append(s.charAt(index));
                index++;
            }
        }

        return res.toString();
    }
}
