package com.datastructure.ds.interview.mathpuzzles;

import java.util.ArrayList;

class Bottle {
    private boolean poisoned = false;
    private int id;

    public Bottle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setAsPoisoned() {
        poisoned = true;
    }
}


class TestStrip {
    public static int DAYS_FOR_RESULT = 7;
    private int id;
    private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();

    public TestStrip(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // resize list of days/drops to be large enough
    private void sizeDropsForDay(int day) {
        while (dropsByDay.size() <= day) {
            dropsByDay.add(new ArrayList<Bottle>());
        }
    }

    // add drop drom bottle on specific day
    public void addDropOnDay(int day, Bottle bottle) {
        sizeDropsForDay(day);
        ArrayList<Bottle> drops = dropsByDay.get(day);
        drops.add(bottle);
    }

    // checks if any of the bottles in the set are poisoned
    private boolean hasPoison(ArrayList<Bottle> bottles) {
        for (Bottle b: bottles) {
            if (b.isPoisoned()) {
                return true;
            }
        }
        return false;
    }

    // gets bottles used in the test DAYS_FOR_RESULT days ago
    public ArrayList<Bottle> getLastWeeksBottles(int day) {
        if (day < DAYS_FOR_RESULT) {
            return null;
        }
        return dropsByDay.get(day - DAYS_FOR_RESULT);
    }

    // checks for poisoned bottles since before DAYS_FOR_RESULT
    public boolean isPositiveOnDay(int day) {
        int testDrop = day - DAYS_FOR_RESULT;
        if (testDrop < 0 || testDrop >= dropsByDay.size()) {
            return false;
        }
        for (int d = 0; d <= day; d++) {
            ArrayList<Bottle> bottles = dropsByDay.get(d);
            if (hasPoison(bottles)) {
                return true;
            }
        }
        return false;
    }
}







