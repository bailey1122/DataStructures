package com.datastructure.ds.circularSinglyLinkedList;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CircularSinglyLinkedListTest {

    protected CircularSinglyLinkedList circularSinglyLinkedList;

    @Before
    public void setUp() throws Exception {
        circularSinglyLinkedList = new CircularSinglyLinkedList();
    }

    @Test
    public void testInsertAtTheBeginning() {
        circularSinglyLinkedList.insertAtTheBeginning(3);
        assertThat(circularSinglyLinkedList.length(), is(1));
    }
}
