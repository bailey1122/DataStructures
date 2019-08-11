package com.datastructure.ds.interview.bigo;

// O(2^N) or 0(1.6^N)
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.allfib(6);

    }

    public void allfib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib1(i));
        }
    }

    public int fib1(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2); // 1; 1; 1+1=2; 2+1=3; 3+2=5; 5+3=8;
    }
}
