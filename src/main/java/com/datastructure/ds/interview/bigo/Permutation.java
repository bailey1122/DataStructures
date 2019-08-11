package com.datastructure.ds.interview.bigo;

// O(n^2 * n!)
public class Permutation {
    public static void main(String[] args) {
        String str = "Hello world";
        Permutation permutation = new Permutation();
        permutation.permutation1(str);
    }

    public void permutation1(String str) {
        permutation1(str, "");
    }

    public void permutation1(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation1(rem, prefix + str.charAt(i));
            }
        }
    }
}
