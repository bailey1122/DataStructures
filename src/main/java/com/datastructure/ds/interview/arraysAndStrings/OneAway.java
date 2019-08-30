package com.datastructure.ds.interview.arraysAndStrings;

// O(n) time, when n is the length of the shorter string
public class OneAway {
    public static void main(String[] args) {
        String first = "apple";
        String second = "aple";

        OneAway oneAway = new OneAway();
        System.out.println(oneAway.oneEditAway(first, second));
    }

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != s1.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    // check if you can insert a character into s1 to make s2
    boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s2.charAt(index2) != s1.charAt(index1)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
