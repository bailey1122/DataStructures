package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        while (true) {
            slow = getNextNumber(slow);
            fast = getNextNumber(fast);
            fast = getNextNumber(fast);

            if (slow == fast) break;
        }

        return slow == 1;
    }

    private int getNextNumber(int n) {
        int count = 0;

        while (n > 0) {
            count += (n % 10) * (n %10);
            n /= 10;
        }

        return count;
    }

    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }

            set.add(n);
            n = getNextNumber(n);
        }

        return true;
    }

    private int getNextNumber2(int n) {
        int count = 0;
        while (n > 0) {
            count += (n % 10) * (n % 10);
            n /= 10;
        }

        return count;
    }
}
