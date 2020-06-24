package com.datastructure.ds.interview.leetc;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        int[] stack = new int[T.length];

        int top = -1;

        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }

            stack[++top] = i;
        }

        return res;
    }
}
