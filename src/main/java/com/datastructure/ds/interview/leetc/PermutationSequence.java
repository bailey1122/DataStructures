package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        List<Integer> values = new ArrayList<Integer>();

        int f = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
            factorial[i] = f;
            values.add(i);
        }

        k--;

        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            res.append(values.get(index));
            values.remove(index);
            k -= index * factorial[n - i];
        }

        return res.toString();
    }
}
