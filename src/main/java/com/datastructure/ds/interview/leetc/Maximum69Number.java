package com.datastructure.ds.interview.leetc;

public class Maximum69Number {

    public int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
