package com.datastructure.ds.interview.leetc;

import java.util.stream.Stream;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int[] arr = Stream.of((a + b).split("\\+|i"))
                .mapToInt(Integer::parseInt).toArray();

        return (arr[0] * arr[2] - arr[1] * arr[3]) + "+" +
                (arr[0] * arr[3] + arr[1] * arr[2]) + "i";
    }
}
