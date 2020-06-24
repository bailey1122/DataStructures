package com.datastructure.ds.interview.leetc;

public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0) return 0;

        int[] arr = new int[n + 1];
        arr[n] = 1;
        arr[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;

            arr[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ?
                    arr[i + 1] + arr[i + 2] : arr[i + 1];
        }

        return arr[0];
    }
}
