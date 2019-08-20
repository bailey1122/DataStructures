//package com.datastructure.ds.interview.exercises;
//
//public class AddTwoNumbers {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode lif = new ListNode(); // first
//        ListNode lis = new ListNode(); // second
//
//        for (int i = l1.size() - 1; i >= 0; i--) {
//            int t = l1.get(i);
//            lif.put(t);
//
//            int d = l2.get(i);
//            lis.put(d);
//        }
//
//        int s = 0;
//        int s2 = 0;
//        for (int i = 0; i < lif.size(); i++) {
//            s += lif.get(i);
//            s += lis.get(i);
//        }
//        return s + s2;
//    }
//}
