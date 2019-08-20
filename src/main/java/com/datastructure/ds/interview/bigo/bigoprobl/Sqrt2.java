package com.datastructure.ds.interview.bigo.bigoprobl;

// O(sqrt(n))
public class Sqrt2 {
    public static void main(String[] args) {
        Sqrt2 sqrt2 = new Sqrt2();
        System.out.println(sqrt2.sqrt(9));
    }

    int sqrt(int n) {
        for (int guess = 1; guess * guess <=n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }
}
