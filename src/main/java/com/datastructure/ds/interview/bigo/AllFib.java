package com.datastructure.ds.interview.bigo;

// O(2^n)
public class AllFib {
    public static void main(String[] args) {
        AllFib allFib = new AllFib();
        allFib.allFib(4);
    }

    void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i)); // 0,1,2,3. 5 is not included
        }
    }

    int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
