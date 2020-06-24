package com.datastructure.ds.interview.mathpuzzles;

public class  SieveOfEratosthenes  {

    public boolean[] sieveOfEratosthenes(int max) {
        boolean[] arr = new boolean[max + 1];

        init(arr);
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            crossOff(arr, prime);

            prime = getNextPrime(arr, prime);
        }

        return arr;
    }

    private int getNextPrime(boolean[] arr, int prime) {
        int next = prime + 1;
        while (next < arr.length && !arr[next]) {
            next++;
        }

        return next;
    }

    private void crossOff(boolean[] max, int prime) {
        for (int i = prime * prime; i < max.length; i += prime) {
            max[i] = false;
        }
    }

    private void init(boolean[] arr) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
    }
}
