package com.datastructure.ds.interview.arraysAndStrings;

import java.util.ArrayList;

// O(1)
public class Arr {
    public static void main(String[] args) {
        String[] a1 = {"a","b","c","d"};
        String[] a2 = {"e","f","g","h"};
        Arr arr = new Arr();
        System.out.println(arr.merge(a1, a2));
    }

    ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) sentence.add(w);
        for (String w : more) sentence.add(w);
        return sentence;

//        for(int i = 0; i < words.length; i++) {
//            sentence.add(words[i]);
//        }
    }
}
