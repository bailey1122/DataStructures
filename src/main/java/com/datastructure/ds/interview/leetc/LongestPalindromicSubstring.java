package com.datastructure.ds.interview.leetc;

public class LongestPalindromicSubstring {

    // TC: O(n^2). Since expanding a palindrome around its center could take O(n) time.
    // SC: O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }



    // TC: O(N) where N is the length of s
    public int longestPalSubstr(String s) {
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

        int length = 0;
        int ctr = 0;
        for (int i = 1; i < Z.length - 1; i++) {
            if (Z[i] > length) {
                length = Z[i];
                ctr = i;
            }
        }

        System.out.println("Longest palindromic substring centered at index i/2: " + lpsc(2, Z, s));
        System.out.println();
        System.out.println("LPS: " + s.substring( (ctr - 1 - length) / 2, (ctr - 1 + length) / 2 ));
        return length;
    }

    // longest palindromic substring centered at index i/2
    String lpsc(int i, int[] Z, String s) {
        int length = Z[i + 2];
        int cntr = i + 2;
        return s.substring( (cntr - 1 - length) / 2, (cntr - 1 + length) / 2 );
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalSubstr("ABAAB"));
        System.out.println();
        System.out.println(l.longestPalindrome("ABAAB"));
    }
}