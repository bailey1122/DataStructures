package com.datastructure.ds.interview.arraysAndStrings;

// O(n)
public class PalindromePermutation2 {
    public static void main(String[] args) {
        String s = "mom";
        PalindromePermutation2 pp2 = new PalindromePermutation2();
        System.out.println(pp2.isPermutationOfPalindrome2(s));
    }

    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber2(c);
            if (x != -1) {
                table[x]++; // count how many times
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    // Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
    // This is case insensitive. Non-letter characters map to -1
    int getCharNumber2(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

}













