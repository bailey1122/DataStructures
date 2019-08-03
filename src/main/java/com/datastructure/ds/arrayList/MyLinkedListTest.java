package com.datastructure.ds.arrayList;

import com.datastructure.ds.analysisOfAlgorithms.MyArrayListTest;

import java.util.ArrayList;

public class MyLinkedListTest extends MyArrayListTest {

//     @throws java.lang.Exception;

     public void setUp() throws Exception {
         list = new ArrayList<Integer>();
         list.add(1);
         list.add(2);
         list.add(3);

         myList = new MyLinkedList<Integer>();
         myList.addAll(list);
     }
}