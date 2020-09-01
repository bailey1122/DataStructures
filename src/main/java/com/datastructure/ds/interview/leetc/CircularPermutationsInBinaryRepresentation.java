package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationsInBinaryRepresentation {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < 1 << n; i++) {// 0 1
            res.add(start ^ i ^ i >> 1);
        }

        return res;
    }
}
