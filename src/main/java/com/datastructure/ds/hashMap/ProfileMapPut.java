package com.datastructure.ds.hashMap;

import com.datastructure.ds.linkedList.Profiler;
import org.jfree.data.xy.XYSeries;

import java.util.HashMap;
import java.util.Map;

public class ProfileMapPut {
    public static void main(String[] args) {
//        profileHashMapPut();
//        profileMyHashMapPut();
        profileMyFixedHashMapPut();
    }

    // characterize the run time of putting a key in java.util.HashMap
    public static void profileHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;
            @Override
            public void setup(int n) {
                map = new HashMap<String, Integer>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 8000;
        int endMillis = 1000;
        runProfiler("HashMap put", timeable, startN, endMillis);
    }

    // characterize the run time of putting a key in MyHashMap
    public static void profileMyHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;
            @Override
            public void setup(int n) {
                map = new MyHashMap<String, Integer>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 1000;
        int endMillis = 5000;
        runProfiler("MyHashMap put", timeable, startN, endMillis);
    }

    public static void profileMyFixedHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;
            @Override
            public void setup(int n) {
                map = new MyFixedHashMap<String, Integer>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 8000;
        int endMillis = 1000;
        runProfiler("MyFixedHashMap put", timeable, startN, endMillis);
    }

    private static void runProfiler(String title, Profiler.Timeable timeable, int startN, int endMillis) {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series);
    }

}
