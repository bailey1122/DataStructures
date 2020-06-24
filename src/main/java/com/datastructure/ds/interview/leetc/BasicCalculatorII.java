package com.datastructure.ds.interview.leetc;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int num = 0, sum = 0, tempSum = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (lastSign) {
                    case '+' :
                        sum += tempSum;
                        tempSum = num;
                        break;
                    case '-' :
                        sum += tempSum;
                        tempSum = -num;
                        break;
                    case '*' :
                        tempSum *= num;
                        break;
                    case '/' :
                        tempSum /= num;
                        break;
                }

                lastSign = c;
                num = 0;
            }
        }

        sum += tempSum;

        return sum;
    }

    public int calculate2(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();

        int num = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    stack.push(num);
                } else if (lastSign == '-') {
                    stack.push(-num);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }

                lastSign = c;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            num += stack.pop();
        }

        return num;
    }
}
