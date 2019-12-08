package com.datastructure.ds.bit;

public class GetBit {

    boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
}
