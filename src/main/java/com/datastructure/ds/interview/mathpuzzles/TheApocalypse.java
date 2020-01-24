package com.datastructure.ds.interview.mathpuzzles;

import java.util.Random;

public class TheApocalypse {

    int runNFamilies(int n) {
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (girls + boys);
    }

    int[] runOneFamily() {
        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while (girls == 0) { // until we have a girl
            if (random.nextBoolean()) { // girl
                girls += 1;
            } else {
                boys += 1; // boy
            }
        }
        int[] genders = {girls, boys};
        return genders;
    }
}