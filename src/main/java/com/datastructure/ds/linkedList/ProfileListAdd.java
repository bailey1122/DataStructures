package com.datastructure.ds.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import com.datastructure.ds.linkedList.Profiler.Timeable;

public class ProfileListAdd {
    public static void main(String[] args) {
        System.out.println("The first column is problem size, n;");
        System.out.println("the second column is run time in milliseconds");
//        profileArrayListAddEnd();
//        profileArrayListAddBeginning();
//        profileLinkedListAddBeginning();
        profileLinkedListAddEnd();
    }

    // characterize the run time of adding to the end of an ArrayList.
    // Linear. The estimated slope is close to 1. Performing n add operations takes time
    // proportional to n raised to the exponent 1
    public static void profileArrayListAddEnd() {
        Timeable timeable = new Timeable() {
            List<String> list;
            @Override
            public void setup(int n) {
                list = new ArrayList<String>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add("a string");
                }
            }
        };
        int startN = 4000;
        int endMillis = 1000;
        runProfiler("ArrayList add end", timeable, startN, endMillis);
    }

    // characterize the run time of adding to the beginning of an ArrayList.
    // Quadratic 'cause you perform a linear operation n time.
    // Each add operation is linear. The estimated slope is near 2.
    public static void profileArrayListAddBeginning() {
        Timeable timeable = new Timeable() {
            List<String> list;
            @Override
            public void setup(int n) {
                list = new ArrayList<String>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add(0, "b string"); // each operation is linear
                }
            }
        };
        int startN = 4000;
        int endMillis = 10000;
        runProfiler("ArrayList add beginning", timeable, startN, endMillis);

    }

    // characterize the run time of adding to the beginning of a LinkedList
    public static void profileLinkedListAddBeginning() {
        Timeable timeable = new Timeable() {
            List<String> list;
            @Override
            public void setup(int n) {
                list = new LinkedList<String>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add(0, "c string");
                }
            }
        };
        int startN = 128000;
        int endMillis = 2000;
        runProfiler("LinkedList add beginning", timeable, startN, endMillis);
    }

    // characterize the run time of adding to the end of a LinkedList
    public static void profileLinkedListAddEnd() {
        Timeable timeable = new Timeable() {
            List<String> list;
            @Override
            public void setup(int n) {
                list = new LinkedList<String>();
            }

            @Override
            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add("d string");
                }
            }
        };
        int startN = 64000;
        int endMillis = 1000;
        runProfiler("LinkedList add end", timeable, startN, endMillis);
    }

    // runs the profiles and displays results

    // @param timeable
    // @param startN
    // @param endMillis
    private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series);
    }
}







































