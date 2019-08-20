package com.datastructure.ds.interview.bigo.bigoprobl;

// O(b)
public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power1(2, 3));
    }

    int power1(int a, int b) {
        if (b < 0) {
            return 0; // error
        } else if (b == 0) {
            return 1;
        } else {
            return a * power1(a, b - 1);
        }
    }
}
