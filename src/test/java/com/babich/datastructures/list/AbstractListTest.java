package com.babich.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public abstract class AbstractListTest {

    List listWithZeroElements = getList();
    List listWithFiveElements = getList();

    public abstract List getList();

    @Before
    public void before() {
        int newSize = 5;

        char c = 'A';
        for (int i = 0; i < newSize; i++) {
            String val = String.valueOf(c);
            listWithFiveElements.add(val);
            c++;
        }
    }

    @Test
    public void testAdd() {
        listWithZeroElements.add("A");
        listWithZeroElements.add("B");
        listWithZeroElements.add("C");
        listWithZeroElements.add("D");

        assertEquals("A", listWithZeroElements.get(0));
        assertEquals("B", listWithZeroElements.get(1));
        assertEquals("C", listWithZeroElements.get(2));
        assertEquals("D", listWithZeroElements.get(3));
    }

    @Test
    public void testAddByIndex() {
        listWithZeroElements.add("A");
        listWithZeroElements.add("B");
        listWithZeroElements.add("D");
        listWithZeroElements.add("E");
        listWithZeroElements.add("G");

        assertEquals("D", listWithZeroElements.get(2));
        assertEquals("G", listWithZeroElements.get(4));

        listWithZeroElements.add("C", 2);
        listWithZeroElements.add("F", 4);
        listWithZeroElements.add("AA", 0);
        listWithZeroElements.add("GG", 6);

        assertEquals("C", listWithZeroElements.get(3));
        assertEquals("GG", listWithZeroElements.get(6));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexException() {
        listWithZeroElements.add(0, 1);
    }

    @Test
    public void testRemove() {
        assertEquals(5, listWithFiveElements.size());
        assertEquals("E", listWithFiveElements.get(4));
        assertEquals("E", listWithFiveElements.remove(4));
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("A", listWithFiveElements.remove(0));
        assertEquals("C", listWithFiveElements.remove(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByInvalidIndex() {
        listWithFiveElements.remove(5);
    }

    @Test
    public void testGet() {
        assertEquals(5, listWithFiveElements.size());
        assertEquals("B", listWithFiveElements.get(1));
        assertEquals("C", listWithFiveElements.get(2));
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("E", listWithFiveElements.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {
        listWithFiveElements.set("A", 4);
        listWithFiveElements.set("B", 3);
        listWithFiveElements.set("C", 2);
        listWithFiveElements.set("D", 1);
        listWithFiveElements.set("E", 0);

        assertEquals("E", listWithFiveElements.get(0));
        assertFalse(listWithFiveElements.contains("S"));
        assertNotEquals("E", listWithFiveElements.get(4));
        listWithFiveElements.get(6);
    }

    @Test
    public void testClear() {
        assertEquals(5, listWithFiveElements.size());
        listWithFiveElements.clear();
        assertEquals(0, listWithFiveElements.size());
        assertTrue(listWithFiveElements.size() == 0);
    }

    @Test
    public void testSize() {
        assertTrue(listWithFiveElements.size() == 5);
        assertTrue(listWithZeroElements.size() == 0);
         }

    @Test
    public void testIsEmpty() {
        assertEquals(5, listWithFiveElements.size());
        assertFalse(listWithFiveElements.isEmpty());
        assertFalse(listWithFiveElements.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(listWithFiveElements.contains("A"));
        assertTrue(listWithFiveElements.contains("B"));
        assertTrue(listWithFiveElements.contains("C"));
        assertTrue(listWithFiveElements.contains("D"));
        assertTrue(listWithFiveElements.contains("E"));
        assertFalse(listWithFiveElements.contains("F"));
        listWithFiveElements.add("F");
        assertTrue(listWithFiveElements.contains("F"));
    }

    @Test
    public void testIndexOf() {

        assertEquals(0, listWithFiveElements.indexOf("A"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(2, listWithFiveElements.indexOf("C"));
        assertEquals(3, listWithFiveElements.indexOf("D"));
        assertEquals(4, listWithFiveElements.indexOf("E"));
        listWithFiveElements.set("E", 0);
        listWithFiveElements.set("A", 3);
        assertEquals("E", listWithFiveElements.get(0));
        assertEquals("A", listWithFiveElements.get(3));
        assertEquals(0, listWithFiveElements.indexOf("E"));
        assertEquals(3, listWithFiveElements.indexOf("A"));
        listWithFiveElements.add("E", 4);
        assertEquals(5, listWithFiveElements.lastIndexOf("E"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(1, listWithFiveElements.lastIndexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(0, listWithFiveElements.lastIndexOf("A"));
        listWithFiveElements.set("A", 1);
        assertEquals(1, listWithFiveElements.lastIndexOf("A"));
        assertEquals(4, listWithFiveElements.lastIndexOf("E"));
        listWithFiveElements.add("E");
        assertEquals(5, listWithFiveElements.lastIndexOf("E"));
    }
}






