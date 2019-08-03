package com.datastructure.ds.analysisOfAlgorithms;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    int size; // keeps track of the number of elements
    private T[] array; // stores the elements

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // you can't instantiate an array of T[], but you can instantiate an array
        // of Object and the typecast it
        array = (T[]) new Object[10];
        size = 0; // most of the time, the length of the array is bigger than size, so there're unused slots in the array
    }

    public boolean add(T element) { // adds elements to the list
        if (size >= array.length) {
            // make a bigger array and copy over the elements
            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // add the element to get the resizing
        add(element);

        // shift the elements
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        // put the new one in the right place
        array[index] = element;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean flag = true;
        for (T element : collection) {
            flag &= add(element);
        }
        return flag;
    }

    public boolean addAll(int index, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        // this version doesn't actually null out the references
        // in the array, so it might delay garbage collection
        size = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int indexOf(Object target) {
        for (int i = 0; i < size; i++ ) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    // checks whether an element of the array is the target.
    // Handles the special case that the target is null
    // @param target
    // @param object
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).iterator();
    }

    public int lastIndexOf(Object target) {
        // see notes on indexOf
        for (int i = size-1; i >= 0; i--) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    public ListIterator<T> listIterator() {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        // make a copy of the array
        T[] copy = Arrays.copyOf(array, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator(index);
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public T remove(int index) {
        T element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj : collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public T set(int index, T element) {
        // no need to check index; get will do it for us
        T old = get(index);
        array[index] = element;
        return old;
    }

    public int size() {
        return size;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        T[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
        return Arrays.asList(copy);
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public <U> U[] toArray(U[] array) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        // insert elements into in an array. Add
        int index = 1; // an index
//        int position = 2;
        int element = 2; // a value

        int[] array = {6, 3, 7, 5, 1}; // create an array
//                       6, 3, 7, 5, 5;
//                       6, 3, 7, 7, 5;
//                       6, 3, 3, 7, 5;
//                       6, 2, 3, 7, 5
        System.out.println(array); // will give [I@hash
        int size = array.length; // get a length of the array

        System.out.println("An initial array");
        for (int h = 0; h < array.length; h++) {
            System.out.print(" indx: " + h);
            System.out.println(" , val: " + array[h]);
        }

        System.out.println(" ");
        // going from the end to the start
        for (int i = size - 1; i > index; i--) {
//        for (int i = size - 1; i > position - 1; i--)
            array[i] = array[i - 1]; // array[i] means the end of array, array[i-1] replace the next one
            // till i gets the specific index that our case is 1
        }
        array[index] = element; // set the new element into the index
//        array[position - 1] = element;
        // get values
        for (int j = 0; j < array.length; j++) {
            System.out.print(" indx: " + j);
            System.out.println(" , val: " + array[j]);
        }


        System.out.println(" ");
        System.out.println(" ");


        // delete an element from an array
        int delete = 80;
        int diffdelete = 200; // a fake element
        int count = 0; // keep track a place

        int[] array2 = {10,40,30,80,60,20};
//                        10,40,30,80,20,20;
//                        10,40,30,60,20,20

        System.out.println("An initial array 2");
        for (int p = 0; p < array2.length; p++) {
            System.out.print(" indx: " + p);
            System.out.println(" , val: " + array2[p]);
        }

        for (int z = 0; z < array2.length; z++) {
            if (delete == array2[z]) {
                for (int j = z; j < array2.length-1; j++) { // set array2.length-1 if we don't wanna get
                    array2[j] = array2[j + 1]; // an ArrayIndexOutOfBoundsException
                }
                count = count + 1; // good
                break;
            }
        }
        if (count==0) {
            System.out.println("The element not found");
        } else {
            System.out.println("The element deleted successfully");
            // get the new array if everything was good
            System.out.println(" ");
            for (int a = 0; a < array2.length; a++) {
                System.out.print(" indx: " + a);
                System.out.println(" , val: " + array2[a]);
            }
        }
        System.out.println(" ");
        System.out.println(" ");

        // an multidimensional JAGGED-ARRAY
        System.out.println("An multidimensional JAGGED-ARRAY");
        int[][] marray = {{2,7,4,5,6,3}, {20,30}, {40,50,60}}; // JAGGED-ARRAY
//        int[][] m = new int[3][]; // three columns with no rows
//        m[0] = new int[6]; // declare the first row
//        m[1] = new int[2]; // declare the second row
//        m[2] = new int[3]; // declare the third row
//
//        m[0][0] = 2;
//        m[0][1] = 7;
//        m[0][2] = 4;
//        m[0][3] = 5;
//        m[0][4] = 6;
//        m[0][5] = 3;
//
//        m[1][0] = 20;
//        m[1][1] = 30;
//
//        m[2][0] = 40;
//        m[2][1] = 50;
//        m[2][2] = 60;
        System.out.println("The JAGGED-ARRAY's size: " + marray.length);
        System.out.println("{2,7,4,5,6,3} size: " + marray[0].length);
        // marray.length refers to this like index=0,1,2 respectively {{2,7,4,5,6,3}, {20,30}, {40,50,60}}
        for (int q = 0; q < marray.length; q++) { // marray.length = 3
            // marry[q].length refers to size6={2,7,4,5,6,3}or size2={20,30}
            for (int w = 0; w < marray[q].length; w++) { // or size3={40,50,60}
                // refers like [0][0]=2 element, [0,1]=7, [1,0]=20 to {2,7,4,5,6,3},
                System.out.print(marray[q][w] + " "); // {20,30}, {40,..
            }
            System.out.println(" "); // when w < marray[q].length is false
        }

        // get the array
        System.out.println(marray); // will give [[I@hash of {{2,7,4,5,6,3}, {20,30}, {40,50,60}}
        System.out.println(marray[0]); // give [I@hash of {2,7,4,5,6,3}
        System.out.println(marray[0][0]); // give 2 from {2,7,4,5,6,3}

        System.out.println(" ");
        System.out.println(" ");


        // multidimensional MATRIX-ARRAY
        System.out.println("An multidimensional MATRIX-ARRAY");
        int[][] marray2 = new int[2][3]; // two rows and thee columns
//        int[][] m2 = {{10,20,30}, {40,50,60}}; // MATRIX-ARRAY
        System.out.println("The MATRIX-ARRAY's size: " + marray2.length);
        marray2[0][0] = 10; // declare the first row
        marray2[0][1] = 20;
        marray2[0][2] = 30;

        marray2[1][0] = 40; // declare the second row
        marray2[1][1] = 50;
        marray2[1][2] = 60;

        for (int e = 0; e < marray2.length; e++) {
            for (int r = 0; r < marray2[e].length; r++) {
                System.out.print(marray2[e][r] + " ");
            }
        }


        System.out.println("");
        System.out.println("");
        System.out.println("");

        // double size of an array
        int[] source = {1,2,3,4,5};
        int[] destination = new int[source.length * 2];

        for (int n = 0; n < source.length; n++) {
            destination[n] = source[n]; // set values to destination from source[n]
        }

        for (int b = 0; b < destination.length; b++) {
            System.out.println(destination[b]);
        }
    }
}









































































































































