package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) list.add(i ^ i >> 1);

        return list;
    }
}
