package com.datastructure.ds.interview.arraysAndStrings;

// O(n) time, when n is the length of the shorter string
public class OneAway2 {
    public static void main(String[] args) {
        String first = "apple";
        String second = "aple";

        OneAway2 oneAway2 = new OneAway2();
        System.out.println(oneAway2.oneEditAway2(first, second));
    }

    boolean oneEditAway2(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) { // the first string must be greater
            return false;
        }

        // get shorter and longer string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s2.charAt(index2) != s1.charAt(index1)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length()) { // on replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // if matching, move shorter pointer
            }
            index2++; // always move pointer for longer string
        }
        return true;
    }
}
