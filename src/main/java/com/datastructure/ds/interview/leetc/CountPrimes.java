package com.datastructure.ds.interview.leetc;

public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] arr = new boolean[n];
        init(arr);
        int prime = 2;

        int count = 0;

        while (prime <= Math.sqrt(n)) {
            crossOff(arr, prime);

            prime = getNextPrime(arr, prime);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) count++;
        }

        return count;
    }

    private int getNextPrime(boolean[] arr, int prime) {
        int next = prime + 1;
        while (next < arr.length && !arr[next]) {
            next++;
        }

        return next;
    }

    private void crossOff(boolean[] arr, int prime) {
        for (int i = prime * prime; i < arr.length; i += prime) {
            arr[i] = false;
        }
    }

    private void init(boolean[] arr) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
    }
}
