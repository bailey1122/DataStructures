package com.datastructure.ds.analysisOfAlgorithms;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyArrayListTest {

    protected List<Integer> myList;
    protected List<Integer> list;

    // @throws java.lang.Exception
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyArrayList<Integer>();
        myList.addAll(list);
    }

    // test method for MyArrayList#MyArrayList()
    @Test
    public  void  testMyList() {
        assertThat(myList.size(), is(3));
    }

    // test method for MyArrayList#add(Object)
    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            myList.add(i);
        }
        System.out.println(Arrays.toString(myList.toArray()));
        assertThat(myList.get(18), is(new Integer(19)));
    }

    // test method for MyArrayList#add(int, Object)
    @Test
    public void testAddIntT() {
        myList.add(1, 5);
        System.out.println(Arrays.toString(myList.toArray()));
        assertThat(myList.get(1), is(new Integer(5)));
        assertThat(myList.size(), is(4));

        try {
            myList.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            myList.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        myList.add(0, 6);
        System.out.println(Arrays.toString(myList.toArray()));
        assertThat(myList.get(0), is(6));

        myList.add(5, 7);
        System.out.println(Arrays.toString(myList.toArray()));
        assertThat(myList.get(5), is(new Integer(7)));
    }

    // test method for MyArrayList#addAll(java.util.Collection)
    @Test
    public void testAddAllCollectionOfQextendsT() {
        myList.addAll(list);
        myList.addAll(list);
        myList.addAll(list);
        assertThat(myList.size(), is(12));
        assertThat(myList.get(5), is(new Integer(3)));
    }

    // test method for MyArrayList#clear()
    @Test
    public void testClear() {
        myList.clear();
        assertThat(myList.size(), is(0));
    }

    // test method for MyArrayList#contains(Object)
    @Test
    public void testContains() {
        assertThat(myList.contains(1), equalTo(true));
        assertThat(myList.contains(4), equalTo(false));
        assertThat(myList.contains(null), equalTo(false));
        myList.add(null);
        assertThat(myList.contains(null), equalTo(true));
    }

    // test method for MyArrayList#containsAll(java.util.Collection)
    @Test
    public void testContainsAll() {
        assertThat(myList.containsAll(list), equalTo(true));
    }

    // test method for MyArrayList#get(int)
    @Test
    public void testGet() {
        assertThat(myList.get(1), is(new Integer(2)));
    }

    // test method for MyArrayList#indexOf(Object)
    @Test
    public void testIndexOf() {
        assertThat(myList.indexOf(1), is(0));
        assertThat(myList.indexOf(2), is(1));
        assertThat(myList.indexOf(3), is(2));
        assertThat(myList.indexOf(4), is(-1));
    }

    // test method for MyArrayList#indexOf(Object)
    @Test
    public void testIndexOfNull() {
        assertThat(myList.indexOf(null), is(-1));
        myList.add(null);
        assertThat(myList.indexOf(null), is(3));
    }

    // test method for MyArrayList#iterator()
    @Test
    public void testIterator() {
        Iterator<Integer> iter = myList.iterator();
        assertThat(iter.next(), is(new Integer(1)));
        assertThat(iter.next(), is(new Integer(2)));
        assertThat(iter.next(), is(new Integer(3)));
        assertThat(iter.hasNext(), equalTo(false));
    }

    // test method for MyArrayList#lastIndexOf(Object)
    @Test
    public void testLastIndexOf() {
        myList.add(2);
        assertThat(myList.lastIndexOf(new Integer(2)), is(3));
    }

    // test method for MyArrayList#remove(Object)
    @Test
    public void testRemoveObject() {
        boolean flag = myList.remove(new Integer(2));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(2));
        assertThat(myList.get(1), is(new Integer(3)));
        System.out.println(Arrays.toString(myList.toArray()));

        flag = myList.remove(new Integer(1));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(1));
        assertThat(myList.get(0), is(new Integer(3)));
        System.out.println(Arrays.toString(myList.toArray()));

        flag = myList.remove(new Integer(5));
        assertThat(flag, equalTo(false));
        assertThat(myList.size(), is(1));
        assertThat(myList.get(0), is(new Integer(3)));
        System.out.println(Arrays.toString(myList.toArray()));

        flag = myList.remove(new Integer(3));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(0));
        System.out.println(Arrays.toString(myList.toArray()));
    }

    // test method for MyArrayList#remove(int)
    @Test
    public void testRemoveInt() {
        Integer val = myList.remove(1);
        assertThat(val, is(new Integer(2)));
        assertThat(myList.size(), is(2));
        assertThat(myList.get(1), is(new Integer(3)));
    }

    // test method for MyArrayList#removeAll(java.util.Collection)
    @Test
    public void testRemoveAll() {
        myList.removeAll(list);
        assertThat(myList.size(), is(0));
    }

    // test method for MyArrayList#set(int, Object)
    @Test
    public void testSet() {
        Integer val = myList.set(1, 5);
        assertThat(val, is(new Integer(2)));

        val = myList.set(0, 6);
        assertThat(val, is(new Integer(1)));

        val = myList.set(2, 7);
        assertThat(val, is(new Integer(3)));

        // return value should be 2
        // list should be [6, 5, 7]
        assertThat(myList.get(0), is(new Integer(6)));
        assertThat(myList.get(1), is(new Integer(5)));
        assertThat(myList.get(2), is(new Integer(7)));
        System.out.println(Arrays.toString(myList.toArray()));

        try{
            myList.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            myList.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good
    }

    // test method for MyArrayList#size()
    @Test
    public void testSize() {
        assertThat(myList.size(), is(3));
    }

    // test method for MyArrayList#subList(int, int)
    @Test
    public void testSubList() {
        myList.addAll(list);
        List<Integer> sub = myList.subList(1, 4);
        assertThat(sub.get(1), is(new Integer(3)));
    }

    // test method for MyArrayList#toArray()
    @Test
    public void testToArray() {
        Object[] array = myList.toArray();
        assertThat((Integer)array[0], is(new Integer(1)));
    }
}






























