package com.datastructure.ds.interview.bit;

public class ClearBit2 {

    int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }
}
