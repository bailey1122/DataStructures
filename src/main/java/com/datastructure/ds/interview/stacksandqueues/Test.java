package com.datastructure.ds.interview.stacksandqueues;

public class Test {

    public static void main(String[] args) {
        int[] packages = {20, 70, 90, 30, 60, 110};
        int truckSpace = 110;

        Test t = new Test();
        int[] k = t.whichPackagesToLoad(truckSpace, packages);

        System.out.println("Our package list: ");
        for (int a1: k) {
        System.out.print(a1 + " ");
        }
    }

    public int[] whichPackagesToLoad(int truckSpace, int[] packages) {
        int[] fpackages = nullify(packages, truckSpace);
        int[] filtered = fMax(fpackages, truckSpace);

        return filtered; // return packages
    }

    // find max available packages
    public int[] fMax(int[] fpackages, int truckSpace) {
        int[] packages = new int[2];
        int max1 = 0;
        int max2 = 0;
        for (int n: fpackages) {
            if (max1 < n && truckSpace - max1 > 30) {
                max2 = max1;
                max1 = n;
            } else if (max2 < n) {
                max2 = n;
            }
        }

        for (int n: fpackages) {
            if (max1 > truckSpace - max2 && n != max1) {
                max1 = n;
            }
        }
        packages[0] = max1;
        packages[1] = max2;

        return packages;
    }

    // nullify inappropriate elements
    private int[] nullify(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target - 30) { // free space(2 packages) 30 units. If this package exceeds the limit
                arr[i] = 0; // then nullify
            }
        }
        return arr;
    }
}
