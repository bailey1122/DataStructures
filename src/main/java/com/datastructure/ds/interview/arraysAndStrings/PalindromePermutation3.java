package com.datastructure.ds.interview.arraysAndStrings;

// O(n)
public class PalindromePermutation3 {
    public static void main(String[] args) {
        String s = "mom";
        PalindromePermutation3 pp3 = new PalindromePermutation3();
        System.out.println(pp3.isPermutationOfPalindrome3(s));
    }

    boolean isPermutationOfPalindrome3(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    // create a bit vector for the string. For each letter with value i, toggle the
    // ith bit
    int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    // check that exactly one bit is set by subtracting one form the integer and
    // ANDing it with the original integer
    boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}


















