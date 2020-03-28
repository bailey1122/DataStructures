package com.datastructure.ds.interview.leetc;

// TC: O(log(x)). There are roughly log10(x) digits in x
// SC: O(1)
public class ReverseInteger {

    public int reverse(int x) {
        int reversedInt = 0;
        while (x != 0) {
            int pop = x % 10;

            x /= 10;

            if (reversedInt > Integer.MAX_VALUE / 10 ||
                    (reversedInt == Integer.MAX_VALUE / 10 &&
                            pop > 7)) {
                return 0;
            }
            else if (reversedInt < Integer.MIN_VALUE / 10 ||
                    (reversedInt == Integer.MIN_VALUE &&
                            pop < -8)) {
                return 0;
            }

            reversedInt = (reversedInt * 10) + pop;
        }

        return reversedInt;
    }
}
