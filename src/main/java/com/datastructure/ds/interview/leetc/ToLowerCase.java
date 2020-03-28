package com.datastructure.ds.interview.leetc;

public class ToLowerCase {

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
