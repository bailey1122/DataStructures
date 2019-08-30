package com.datastructure.ds.interview.bigo;

// O(log n)
public class PowerOf22 {
    public static void main(String[] args) {
        PowerOf22 powerOf22 = new PowerOf22();
        System.out.println(powerOf22.isPowerOfTwo(4));
    }

    boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        else {
            while (n % 2 == 0)
                n /= 2;
                return (n == 1);
        }
    }
}
