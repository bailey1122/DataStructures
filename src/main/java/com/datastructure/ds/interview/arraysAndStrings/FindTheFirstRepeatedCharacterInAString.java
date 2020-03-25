package com.datastructure.ds.interview.arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class FindTheFirstRepeatedCharacterInAString {

    public void printFRC(String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                System.out.println(c);
                break;
            } else {
                set.add(c);
            }
        }
    }

    public static void main(String[] args) {
        FindTheFirstRepeatedCharacterInAString f = new FindTheFirstRepeatedCharacterInAString();
        f.printFRC("helloerty");
    }
}
