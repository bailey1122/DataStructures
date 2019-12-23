package com.datastructure.ds.interview.bit;

public class ClearBit {

    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
}
