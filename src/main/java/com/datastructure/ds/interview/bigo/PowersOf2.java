package com.datastructure.ds.interview.bigo;

// O(log n)
public class PowersOf2 {
    public static void main(String[] args) {
        PowersOf2 powersOf2 = new PowersOf2();
        powersOf2.powers(4);
    }

    int powers(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powers(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
}
