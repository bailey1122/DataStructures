package com.datastructure.ds.dynamicprog;

// a memoization method
public class FibMem {

    int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        FibMem fibMem = new FibMem();
        System.out.println(fibMem.fib(5));
    }
}
