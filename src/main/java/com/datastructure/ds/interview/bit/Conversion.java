package com.datastructure.ds.interview.bit;

public class Conversion {

    int bitSwapRequired1(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += c & 1;
        }
        return count;
    }

    int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c-1)) {
            count++;
        }
        return count;
    }
}
