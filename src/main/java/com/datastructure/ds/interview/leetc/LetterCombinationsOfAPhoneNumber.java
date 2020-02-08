package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC: O(3^N * 4^M) where N is the number of digits in the input that maps to 3
// letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input
// that maps to 4 letters (e.g. 7, 9), and N + M is the total number digits in
// the input. SC: O(3^N * 4^M) since one has to keep 3^N * 4^M solutions
public class LetterCombinationsOfAPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);

                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}