package com.datastructure.ds.interview.sortingAndSearching;

public class FindDuplicates {

    void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(array[i]);
            } else {
                bs.set(num0);
            }
        }
    }
}

class BitSet {

    int[] bitset;

    public BitSet(int size) {
        bitset = new int[(size >> 5) + 1];
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitset[wordNumber] |= 1 << bitNumber;
    }
}