package com.babich.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList list = new LinkedList();

    @Before
    public void before() {
        list.add("String1");
        list.add("String2");
        list.add("String3");
    }

    @Test
    public void add() {
        list.clear();
        assertEquals(list.size(), 0);
        list.add("One");
        assertEquals(list.get(0), "One");
        assertEquals(list.size(), 1);
    }




    @Test
    public void remove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void copy() {
    }
}