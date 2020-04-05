package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC: O(D), where D is the number if integers in range [L, R], and assuming
// log(R) is bounded. In general, the complexity would be O(DlogR)
// SC: O(D)
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = left; i <= right; i++) {
            if (isDividing(i)) res.add(i);
        }

        return res;
    }

    private boolean isDividing(int num) {
        for (char c : String.valueOf(num).toCharArray()) {
            if (c == '0' || num % (c - '0') > 0) {
                return false;
            }
        }

        return true;
    }
}
