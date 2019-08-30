package com.datastructure.ds.interview.arraysAndStrings;

// better than just joining strings
public class StringCompression2 {
    public static void main(String[] args) {
        String str = "aabbbcccc";

        StringCompression2 stcCrs = new StringCompression2();
        System.out.println(stcCrs.compress(str));
    }

    String compress(String str) {
        StringBuilder compressedStr = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedStr.append(str.charAt(i));
                compressedStr.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedStr.length() < str.length() ? compressedStr.toString() : str;
    }
}
