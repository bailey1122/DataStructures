package com.datastructure.ds.interview.bigo.bigoprobl;

// O(logn)
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt1(64));
    }

    int sqrt1(int n) {
        return sqrt1_helper(n, 1, n);
    }

    int sqrt1_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root

        int guess = (min + max) / 2;
        if (guess * guess == n) { // found it
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt1_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt1_helper(n, min, guess -1);
        }
    }
}
