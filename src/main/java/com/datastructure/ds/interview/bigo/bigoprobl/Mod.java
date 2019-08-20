package com.datastructure.ds.interview.bigo.bigoprobl;

// O(1)
public class Mod {
    public static void main(String[] args) {
        Mod mod = new Mod();
        System.out.println(mod.mod1(16, 4));
    }

    int mod1(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }
}
