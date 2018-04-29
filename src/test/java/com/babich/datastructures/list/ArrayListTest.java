package com.babich.datastructures.list;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

    public class ArrayListTest {

        private List listWithZeroElements;
        private List listWithFiveElements;

        @Before
        public void before() {
            listWithZeroElements = new ArrayList();
            listWithFiveElements = new ArrayList(5);

            char c = 'A';
            for (int i = 0; i < 5; i++) {
                String value = String.valueOf(c);
                listWithFiveElements.add(value);
                c++;
            }
        }

        @Test
        public void testGet() {
            char c = 'A';
            for (int i = 0; i < 5; i++) {
                String value = String.valueOf(c);
                assertEquals(value, listWithFiveElements.get(i));
                c++;
            }
        }

        @Test
        public void testRemove() {
            Object removed = listWithFiveElements.remove(1);

            assertEquals(4, listWithFiveElements.size());
            assertEquals("B", removed);
            assertEquals("A", listWithFiveElements.get(0));
            assertEquals("C", listWithFiveElements.get(1));
            assertEquals("D", listWithFiveElements.get(2));
            assertEquals("E", listWithFiveElements.get(3));
        }

        @Test
        public void testIsEmpty() {
            assertTrue(listWithZeroElements.isEmpty());
            assertFalse(listWithFiveElements.isEmpty());
        }

        @Test
        public void testSet() {
            Object updatedValue= listWithFiveElements.set("A", 4);
            assertEquals("E", updatedValue);
            assertEquals("A", listWithFiveElements.get(4));
            assertEquals(4, listWithFiveElements.lastIndexOf("A"));
        }

        @Test
        public void testClear() {
            assertEquals(5, listWithFiveElements.size());
            listWithFiveElements.clear();
            }
        @Test
        public void testSize() {
            assertEquals(5, listWithFiveElements.size());
            assertEquals(0, listWithZeroElements.size());
            listWithFiveElements.add("A");
            assertEquals(1, listWithFiveElements.size());
        }

        @Test
        public void testIndexOf() {
            assertEquals(0, listWithFiveElements.indexOf("A"));
            assertEquals(1, listWithFiveElements.indexOf("B"));
            assertEquals(2, listWithFiveElements.indexOf("C"));
            assertEquals(3, listWithFiveElements.indexOf("D"));
            assertEquals(4, listWithFiveElements.indexOf("E"));
        }

        @Test
        public void testLastIndexOf() {
            assertEquals(4, listWithFiveElements.lastIndexOf("E"));
            assertEquals(3, listWithFiveElements.lastIndexOf("D"));
            assertEquals(1, listWithFiveElements.lastIndexOf("B"));
            assertEquals(0, listWithFiveElements.lastIndexOf("A"));
            listWithFiveElements.set("A", 3);
            assertEquals(3, listWithFiveElements.lastIndexOf("A"));
        }
    }
