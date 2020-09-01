package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {

    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);

        while (res.size() < N) {
            List<Integer> temp = new ArrayList<Integer>();

            for (int i : res) {
                if (i * 2 - 1 <= N) temp.add(i * 2 - 1);
            }

            for (int i : res) {
                if (i * 2 <= N) temp.add(i * 2);
            }

            res = temp;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
