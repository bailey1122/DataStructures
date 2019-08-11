package com.datastructure.ds.interview.bigo;

// swap elements
public class Swap {
    public static void main(String[] args) {
        Swap swap = new Swap();
        swap.swapt("Michael", "John");
    }

    public void swapt(String a, String b) {
        String temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }
}
