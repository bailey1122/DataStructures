package com.datastructure.ds.interview.leetc;

public class BestTimeToBuyAndSellStock {

    // TC: O(n^2)
    // SC: O(1)
    public int maxProfit(int[] prices) {
        int maxProf = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int prof = prices[j] - prices[i];
                if (prof > maxProf) {
                    maxProf = prof;
                }
            }
        }
        return maxProf;
    }

    // TC: O(n)
    // SC: O(1)
    public int maxProfit2(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProf = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if (prices[i] - minVal > maxProf) {
                maxProf = prices[i] - minVal;
            }
        }
        return maxProf;
    }
}
