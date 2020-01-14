package com.datastructure.ds.dynamicprog;

public class SieveOfEratosthenes {

    boolean[] getSieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        init(flags); // set all flags to true other than 0 and 1
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            // cross off remaining multiples of prime
            crossOff(flags, prime);
            // find the next value which is true
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    void crossOff(boolean[] flags, int prime) {
        // we start with (prime * prime) because if we have a k * prime, where
        // k < prime, this value would have already been crossed off in
        // a prior iteration
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }
}  