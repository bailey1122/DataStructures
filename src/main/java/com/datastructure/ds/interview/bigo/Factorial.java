package com.datastructure.ds.interview.bigo;

// O(n)
public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial1(4));
    }

    public int factorial1(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial1(n-1); // 4 * 3 * 2 * 1
        }
    }
}
