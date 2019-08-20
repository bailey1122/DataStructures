package com.datastructure.ds.interview.bigo.bigoprobl;

// 0(logn)
public class SumDigits {
    public static void main(String[] args) {
        SumDigits sumDigits = new SumDigits();
        System.out.println(sumDigits.sumDigits1(10));
    }

    int sumDigits1(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10; // n = n / 10
        }
        return sum;
    }
}
