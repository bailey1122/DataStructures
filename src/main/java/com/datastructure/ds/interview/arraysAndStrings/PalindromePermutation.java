package com.datastructure.ds.interview.arraysAndStrings;

// O(N), where N is the length of the string
public class PalindromePermutation {
    public static void main(String[] args) {
        String s = "mom";
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPermutationOfPalindrome(s));
    }

    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    // check that no more than one character has an odd count
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // map each character to a number. a -> 0, b -> 1, c -> 2, etc.
    // This is case insensitive. Non-letter characters map to -1
    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    // count how many times each character appears
    int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++; // count how many times
            }
        }
        return table;
    }
}





















