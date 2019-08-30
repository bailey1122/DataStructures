package com.datastructure.ds.interview.arraysAndStrings;

public class JoinWords {
    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d"};
        JoinWords joinWords = new JoinWords();
        System.out.println(joinWords.joinWords1(a));
    }

    // O(xn^2) or O(n^2)
    String joinWords1(String[] words) {
        String sentence = "";
        for (String w : words) {
            sentence = sentence + w;
        }
        return sentence;
    }

    ///////////////////////////////////////////////////

    // the right way.
    String joinWords2(String[] words) {
        StringBuilder sentence2 = new StringBuilder();
        for (String w2 : words) {
            sentence2.append(w2);
        }
        return sentence2.toString();
    }
}
