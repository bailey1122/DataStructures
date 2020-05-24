package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<String>();

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int i = 1; i <= n; i++) {
            String temp = "";

            for (int k : map.keySet()) {
                if (i % k == 0) {
                    temp += map.get(k);
                }
            }

            if (temp.isEmpty()) {
                list.add(Integer.toString(i));
            } else {
                list.add(temp);
            }
        }

        return list;
    }
}