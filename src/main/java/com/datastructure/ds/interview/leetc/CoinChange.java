package com.datastructure.ds.interview.leetc;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] arr) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (arr[rem - 1] != 0) return arr[rem - 1];

        int min = Integer.MAX_VALUE;

        for (int c : coins) {
            int res = helper(coins, rem - c, arr);

            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        arr[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return arr[rem - 1];
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;

        int res = 0;

        int[] arr = new int[amount + 1];

        while (++res <= amount) {
            int min = -1;

            for (int c : coins) {
                if (res >= c && arr[res - c] != -1) {
                    int temp = arr[res - c] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }

            arr[res] = min;
        }

        return arr[amount];
    }
}
