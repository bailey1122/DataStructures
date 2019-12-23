package com.datastructure.ds.interview.bit;

// a bit manipulation approach to get the next number
public class NextNumber {

    int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        int p = c0 + c1;

        n |= (1 << p); // flip rightmost non-trailing zero
        n &= ~((1 << p) - 1); // clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // insert (c1-1) ones on the right

        return n;
    }

}