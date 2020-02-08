package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC: O(N). SC: O(1)
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);

            if (div3 && div5) {
                list.add("FizzBuzz");
            } else if (div3) {
                list.add("Fizz");
            } else if (div5) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}