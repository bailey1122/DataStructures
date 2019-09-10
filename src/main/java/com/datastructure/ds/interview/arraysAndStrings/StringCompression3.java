package com.datastructure.ds.interview.arraysAndStrings;

public class StringCompression3 {
    public static void main(String[] args) {
        String str = "aabbbcccc";

        StringCompression3 strC3 = new StringCompression3();
        System.out.println(strC3.compress(str));
    }

    String compress(String str) {
        // check final length and return input string if it'd be longer
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if next character is different than current, append this char to result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if next character is different than current, increase the length
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
