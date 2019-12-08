package com.datastructure.ds.bit;

public class Insertion {

    int updateBits(int n, int m, int i, int j) {
        // create a mask to clear bits i through j in n. EX: i = 2, j = 4.
        // Result should be 11100011. We will use 8 bits for the example
        int allOnes = ~0; // will equal sequence of all 1s

        // 1s before position j, then 0s. left = 11100000
        int left = allOnes << (j + 1);

        // 11s after position i. right = 00000011
        int right = ((1 << i) - 1);

        // all 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;

        // clear bits j through i then put m in there
        int n_cleaned = n & mask; // clear bits j through i
        int m_shifted = m << i; // move m into correct position
        return n_cleaned | m_shifted; // OR them
    }
}
