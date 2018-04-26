package com.babich.datastructures.list;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


public class LinkedListTest {

    LinkedList linkedList;
    LinkedList linkedFiveList;
    int newSize;


    @Before
    public void before() {
        newSize = 5;
        linkedFiveList = new LinkedList();
        linkedList = new LinkedList();

        char c = 'A';
        for (int i = 0; i < newSize; i++) {
            String val = String.valueOf(c);
            linkedFiveList.add(val);
            c++;
        }
    }

    @Test
    public void testAdd() {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
        assertEquals("D", linkedList.get(3));
    }


    @Test
    public void testAddByIndex() {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("G");

        assertEquals("D", linkedList.get(2));
        assertEquals("G", linkedList.get(4));

        linkedList.add("C", 2);
        linkedList.add("F", 4);
        linkedList.add("AA", 0);
        linkedList.add("GG", 6);

        assertEquals("C", linkedList.get(3));
        assertEquals("GG", linkedList.get(6));
       }

    @Test
    public void testRemove() {
        assertEquals(5, linkedFiveList.size);
        assertEquals("E", linkedFiveList.get(4));
        assertEquals("E", linkedFiveList.remove(4));
        assertEquals("D", linkedFiveList.get(3));
        assertEquals("A", linkedFiveList.remove(0));
        assertEquals("C", linkedFiveList.remove(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByInvalidIndex(){
        linkedFiveList.remove(5);
    }

    @Test
    public void testGet() {
        assertEquals(5, linkedFiveList.size);
        assertEquals("B", linkedFiveList.get(1));
        assertEquals("C", linkedFiveList.get(2));
        assertEquals("D", linkedFiveList.get(3));
        assertEquals("E", linkedFiveList.get(4));
       }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {
        linkedFiveList.set("A", 4);
        linkedFiveList.set("B", 3);
        linkedFiveList.set("C", 2);
        linkedFiveList.set("D", 1);
        linkedFiveList.set("E", 0);

        assertEquals("E", linkedFiveList.get(0));
        assertFalse(linkedFiveList.contains("S"));
        assertNotEquals("E", linkedFiveList.get(4));
        linkedFiveList.get(6);
    }

    @Test
    public void testClear() {
        assertEquals(5, linkedFiveList.size());
        linkedFiveList.clear();
        assertEquals(0, linkedFiveList.size());
        assertTrue(linkedFiveList.size == 0);
    }

    @Test
    public void testSize() {
        assertTrue(linkedFiveList.size == 5);
        assertTrue(linkedList.size == 0);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
        assertFalse(linkedFiveList.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(linkedFiveList.contains("A"));
        assertTrue(linkedFiveList.contains("B"));
        assertTrue(linkedFiveList.contains("C"));
        assertTrue(linkedFiveList.contains("D"));
        assertTrue(linkedFiveList.contains("E"));
        assertFalse(linkedFiveList.contains("F"));
        linkedFiveList.add("F");
        assertTrue(linkedFiveList.contains("F"));
    }

    @Test
    public void testIndexOf() {

        assertEquals(0, linkedFiveList.indexOf("A"));
        assertEquals(1, linkedFiveList.indexOf("B"));
        assertEquals(2, linkedFiveList.indexOf("C"));
        assertEquals(3, linkedFiveList.indexOf("D"));
        assertEquals(4, linkedFiveList.indexOf("E"));
        linkedFiveList.set("E", 0);
        linkedFiveList.set("A", 3);
        assertEquals("E", linkedFiveList.get(0));
        assertEquals("A", linkedFiveList.get(3));
        assertEquals(0, linkedFiveList.indexOf("E"));
        assertEquals(3, linkedFiveList.indexOf("A"));
        linkedFiveList.add("E", 4);
        assertEquals(5, linkedFiveList.lastIndexOf("E"));
        assertEquals(1, linkedFiveList.indexOf("B"));
        assertEquals(1, linkedFiveList.lastIndexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(0, linkedFiveList.lastIndexOf("A"));
        linkedFiveList.set("A", 1);
        assertEquals(1, linkedFiveList.lastIndexOf("A"));
        assertEquals(4, linkedFiveList.lastIndexOf("E"));
        linkedFiveList.add("E");
        assertEquals(5, linkedFiveList.lastIndexOf("E"));
    }
}