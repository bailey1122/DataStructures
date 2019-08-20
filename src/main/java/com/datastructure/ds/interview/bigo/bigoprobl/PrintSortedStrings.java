package com.datastructure.ds.interview.bigo.bigoprobl;

// O(kc^k), where 'k' is the length of the string and 'c' is the number of
// characters in the alphabet. O(c^k) time to generate each string. Then,
// we have to check that each of these is sorted, which takes O(k) time.
public class PrintSortedStrings {
    public static void main(String[] args) {
        String prefix = "abc";
        PrintSortedStrings printSortedStrings = new PrintSortedStrings();
        printSortedStrings.printSortedStrings1(3, prefix);
    }

    int numChars = 26;

    void printSortedStrings1(int remaining) {
        printSortedStrings1(remaining, "");
    }

    void printSortedStrings1(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings1(remaining - 1, prefix + c);
            }
        }
    }

    boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }
}
