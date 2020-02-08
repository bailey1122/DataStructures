package com.datastructure.ds.interview.mathpuzzles;

import java.util.ArrayList;
import java.util.Random;

public class TestStripTest {

    int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
        int today = 0;

        // run tests
        while (bottles.size() > 1 && strips.size() > 0) {
            runTestSet(bottles, strips, today);
        }

        // wait for results
        today += TestStrip.DAYS_FOR_RESULT;

        // check results
        for (TestStrip strip: strips) {
            if (strip.isPositiveOnDay(today)) {
                bottles = strip.getLastWeeksBottles(today);
                strips.remove(strip);
                break;
            }
        }

        if (bottles.size() == 1) {
            return bottles.get(0).getId();
        } else {
            return -1;
        }
    }

    // distribute bottles across strips evenly
    void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
        int index = 0;

        for (Bottle bottle: bottles) {
            TestStrip strip = strips.get(index);
            strip.addDropOnDay(day, bottle);
            index = (index + 1) % strips.size();
        }
    }

    ArrayList<Bottle> createBottles(int nBottles, int poisoned) {
        ArrayList<Bottle> bottles = new ArrayList<Bottle>();
        for (int i = 0; i < nBottles; i++) {
            bottles.add(new Bottle(i));
        }

        if (poisoned == -1) {
            Random random = new Random();
            poisoned = random.nextInt(nBottles);
        }
        bottles.get(poisoned).setAsPoisoned();

        System.out.println("Added poison to bottle " + poisoned);

        return bottles;
    }

    ArrayList<TestStrip> createTestStrips(int nTestStrips) {
        ArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();
        for (int i = 0; i < nTestStrips; i++) {
            testStrips.add(new TestStrip(i));
        }
        return testStrips;
    }
}
