package com.datastructure.ds.interview.sortingAndSearching;

public class LCS {

    // dp TC: O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int[][] temp = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = 1 + temp[i - 1][j - 1];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }


    // recursion: TC: 2^n
    public int longestCommonSubsequence2(String text1, String text2) {

        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        return lcsr(str1, str2, 0, 0);
    }

    private int lcsr(char[] str1, char[] str2, int len1, int len2) {
        if (str1.length == len1 || str2.length == len2) {
            return 0;
        }
        if (str1[len1] == str2[len2]) {
            return 1 + lcsr(str1, str2, len1 + 1, len2 + 1);
        } else {
            return Math.max(lcsr(str1, str2, len1 + 1, len2), lcsr(str1, str2, len1, len2 + 1));
        }
    }
}
