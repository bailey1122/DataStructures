package com.datastructure.ds.interview.arraysAndStrings;

// O(p + k^2), where p is the size of the original string and k is the number
// of character sequences
public class StringCompression {
    public static void main(String[] args) {
        String s = "abbbccc";

        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compressBad(s));
    }

    String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }
}
