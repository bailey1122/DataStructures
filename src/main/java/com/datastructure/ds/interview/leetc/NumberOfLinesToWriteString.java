package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(1)
public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        int lines = 1;
        int width = 0;

        for (char c : S.toCharArray()) {
            int charSize = widths[c - 'a'];

            if (charSize + width > 100) {
                width = 0;
                lines++;
            }

            width += charSize;
        }

        res[0] = lines;
        res[1] = width;

        return res;
    }
}
