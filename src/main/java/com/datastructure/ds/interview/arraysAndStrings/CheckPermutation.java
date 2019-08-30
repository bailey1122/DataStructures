package com.datastructure.ds.interview.arraysAndStrings;

public class CheckPermutation {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "edcba";
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.permutation(a, b));

        System.out.println(checkPermutation.permutation2(a, b));
    }

    String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    //////////////////////////////////////////////////////////////

    boolean permutation2(String s2, String t2) {
        if (s2.length() != t2.length()) {
            return false;
        }

        int[] letters = new int[128]; // assumption

        char[] s_array = s2.toCharArray();
        for (char c : s_array) { // count number of each char in s
            letters[c]++;
        }

        for (int i = 0; i < t2.length(); i++) {
            int c = (int) t2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
