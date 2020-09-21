package com.datastructure.ds.interview.leetc;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0; // 0 16 27 28
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) sum += i + num / i;
        }
        sum++;

        return sum == num;
    }
}
