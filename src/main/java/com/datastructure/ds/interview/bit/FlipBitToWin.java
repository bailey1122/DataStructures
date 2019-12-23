package com.datastructure.ds.interview.bit;

import java.util.ArrayList;

// TC: O(b). SC: O(b). Where b is the length of the sequence(number of bits)
public class FlipBitToWin {

    int longestSequence(int n) {
        if (n == -1) return Integer.BYTES * 8;
        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<Integer>();

        int searchingFor = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1;
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);
        return sequences;
    }

    int findLongestSequence(ArrayList<Integer> seq) {
        int maxSeq = 1;

        for (int i = 0; i < seq.size(); i += 2) {
            int zerosSeq = seq.get(i);
            int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;
            if (zerosSeq == 1) {
                thisSeq = onesSeqRight + 1 + onesSeqLeft;
            } if (zerosSeq > 1) {
                thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
            } else if (zerosSeq == 0) {
                thisSeq = Math.max(onesSeqRight, onesSeqLeft);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }
        return maxSeq;
    }
}