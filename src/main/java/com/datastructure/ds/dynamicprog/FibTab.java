package com.datastructure.ds.dynamicprog;

// TC: O(N)
// SC: O(N)
// a tabulation method
public class FibTab {

    int fib(int n) {
        if (n <= 1)
            return n;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }

    public static void main(String[] args) {
        FibTab fibTab = new FibTab();
        System.out.println(fibTab.fib(5));
    }
}
