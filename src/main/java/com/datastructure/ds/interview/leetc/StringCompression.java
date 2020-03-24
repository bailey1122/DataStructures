package com.datastructure.ds.interview.leetc;

public class StringCompression {

    public int compress(char[] chars) {
        int index = 0, pos = 0;

        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && currentChar == chars[index]) {
                index++;
                count++;
            }
            chars[pos++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray())
                    chars[pos++] = c;
            }
        }
        return pos;
    }
}
