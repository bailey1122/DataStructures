package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class FibonacciNumber {

    public int fib(int N) {
        if (N <= 1) return N;

        int a = 0;
        int b = 1;

        while (N > 1) {
            int sum = a + b;

            a = b;
            b = sum;

            N--;
        }

        return b;
    }
}
