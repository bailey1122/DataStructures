package com.datastructure.ds.interview.bit;

// the code for 32-bit integers in Java
public class PairwiseSwap {

    int swapOddEvenBits(int x) {
        return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
    }
}