package com.datastructure.ds.interview.sortingAndSearching;

// TC: O(log n)
public class SortedSearchNoSize {

//    int search(Listy list, int value) {
//        int index = 1;
//        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
//            index *= 2;
//        }
//        return binarySearch(list, value, index / 2, index);
//    }
//
//    int binarySearch(Listy list, int value, int low, int high) {
//        int mid;
//        while (low <= high) {
//            mid = (low + high) / 2;
//            int middle = list.elementAt(mid);
//            if (value < middle || middle == -1) {
//                high = mid - 1;
//            } else if (middle < value) {
//                low = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        String str1 = "ball";
        String str2 = "car";
        System.out.println(str2.compareTo(str1));

        int a = 'b' + 'a' + 'l' + 'l';
        int b = 'c' + 'a' + 'r';
        System.out.println(a);
        System.out.println(b);
    }
}