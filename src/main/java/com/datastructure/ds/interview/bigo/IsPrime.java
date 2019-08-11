package com.datastructure.ds.interview.bigo;

import static java.lang.StrictMath.sqrt;

// O(The square root of n)
public class IsPrime {
    public static void main(String[] args) {
        IsPrime isPrime = new IsPrime();
        System.out.println(isPrime.isPrime1(11));
    }

    public boolean isPrime1(int n) {
        for (int x = 2; x <= sqrt(33); x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }
}
