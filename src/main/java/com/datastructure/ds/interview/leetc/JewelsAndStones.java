package com.datastructure.ds.interview.leetc;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int numJewls = 0;

        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1) {
                numJewls++;
            }
        }

        return numJewls;
    }
}
