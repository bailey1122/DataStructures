package com.datastructure.ds.interview.leetc;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currSum = 0;
        int sum = 0;

        for (int fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currSum++;
            } else {
                currSum = lastFruitCount + 1;
            }

            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            sum = Math.max(sum, currSum);
        }

        return sum;
    }
}
