package com.datastructure.ds.interview.bit;

public class ClearBit3 {

    int clearBitsIthrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }
}
