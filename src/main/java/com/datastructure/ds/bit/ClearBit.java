package com.datastructure.ds.bit;

public class ClearBit {

    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
}
