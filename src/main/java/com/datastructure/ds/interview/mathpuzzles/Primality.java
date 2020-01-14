package com.datastructure.ds.interview.mathpuzzles;

public class Primality {

    boolean primeSlightlyBetter(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
