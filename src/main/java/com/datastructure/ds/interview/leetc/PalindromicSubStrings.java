package com.datastructure.ds.interview.leetc;

public class PalindromicSubStrings {

    // TC: O(N^2) where N is the length of s. Each expansion might do O(N) work.
    // SC: O(1)
    public int countSubstrings(String s) {
        int n = s.length();
        int c = 0;
        for (int ctr = 0; ctr <= n * 2 - 1; ++ctr) {
            int left = ctr / 2;
            int right = left + ctr % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                c++;
                left--;
                right++;
            }
        }
        return c;
    }

    // TC: O(N) where N is the length of s.
    // SC: O(N), the size of A and Z
    public int countSubstrings2(String s) {
        char[] A = new char[2 * s.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';

        int t = 2;
        for (char c : s.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }
        int[] Z = new int[A.length];
        int center = 0;
        int right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);

            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;

            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }

        }
        int ans = 0;
        for (int v : Z) ans += (v + 1) / 2;
        return ans;
    }
}
