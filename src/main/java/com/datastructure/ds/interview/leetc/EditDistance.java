package com.datastructure.ds.interview.leetc;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length(),
                arr[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            arr[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            arr[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j];
                } else {
                    int a = arr[i][j], b = arr[i + 1][j],
                            c = arr[i][j + 1];

                    arr[i + 1][j + 1] = a < b ? (a < c ? a : c)
                            : (b < c ? b : c);
                    arr[i + 1][j + 1]++;
                }
            }
        }

        return arr[m][n];
    }
}
