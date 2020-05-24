package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;

        List<Integer> res = new ArrayList<Integer>();

        int[] lastIndeces = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndeces[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndeces[S.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1};
        arr[0] = -arr[0];
        System.out.println(arr[0]);
    }
}
