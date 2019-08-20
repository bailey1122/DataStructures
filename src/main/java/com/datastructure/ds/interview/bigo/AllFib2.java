package com.datastructure.ds.interview.bigo;

// O(n)
public class AllFib2 {
    public static void main(String[] args) {
        AllFib2 allFib2 = new AllFib2();
        allFib2.allFib(4);
    }

    void allFib(int n) {
        int[] memo = new int[n + 1]; // 5
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i, memo));
        }
    }

    int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
