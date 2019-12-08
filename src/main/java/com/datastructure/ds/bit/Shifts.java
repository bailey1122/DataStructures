package com.datastructure.ds.bit;

// x = -93242, count = 40
public class Shifts {

    int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1; // shift by 1
        }
        return x; // -1 (a sequence of all 1s in a (signed) integer)
    }

    int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1; // shift by 1
        }
        return x; // 0
    }
}
