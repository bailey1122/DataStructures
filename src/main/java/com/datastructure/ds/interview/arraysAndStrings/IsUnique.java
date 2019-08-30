package com.datastructure.ds.interview.arraysAndStrings;

public class IsUnique {
    public static void main(String[] args) {
        String a = "abcdef";
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUniqueChars(a));

        System.out.println();

        System.out.println(isUnique.isUniqueChar2(a));
    }

    // TC: O(n) n is the length of the string. SC: O(1).
    // If you didn't want to assume the character set is fixed, then
    // TC: O(min(c, n)) or O(c). SC: O(c)
    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { // already found this char string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////

    // TC: O(n^2). SC: O(1)
    boolean isUniqueChar2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) { // shifts a bit pattern to the left
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
