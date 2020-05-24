package com.datastructure.ds.interview.leetc;

public class RemoveVowelsFromAString{

    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
