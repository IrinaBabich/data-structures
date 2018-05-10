package com.babich.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public abstract class AbstractStackTest {

    Stack stackWithZeroElements = getStack();
    Stack stackWithFiveElements = getStack();

    public abstract Stack getStack();

    @Before
    public void before() {
        int newSize = 5;
        char c = 'A';
        for (int i = 0; i < newSize; i++) {
            String val = String.valueOf(c);
            stackWithFiveElements.push(val);
            c++;
        }
    }

    @Test
    public void testPush() {
        stackWithZeroElements.push("A");
        stackWithZeroElements.push("B");
        stackWithZeroElements.push("C");
        stackWithZeroElements.push("D");

        assertEquals("D", stackWithZeroElements.pop());
        assertEquals("C", stackWithZeroElements.pop());
        assertEquals("B", stackWithZeroElements.pop());
        assertEquals("A", stackWithZeroElements.pop());
    }

    @Test
    public void testPeek() {
        stackWithZeroElements.push("A");
        stackWithZeroElements.push("B");
        stackWithZeroElements.push("C");
        stackWithZeroElements.push("D");

        assertEquals("D", stackWithZeroElements.peek());
        assertEquals("C", stackWithZeroElements.peek());
        assertEquals("B", stackWithZeroElements.peek());
        assertEquals("A", stackWithZeroElements.peek());

        assertTrue(stackWithFiveElements.peek().equals(2));
        assertFalse(stackWithFiveElements.peek().equals("2"));
    }

    @Test
    public void testPop() {
        assertEquals(5, stackWithFiveElements.size());
        assertEquals("E", stackWithFiveElements.pop());
        assertEquals("D", stackWithFiveElements.pop());
        assertEquals("C", stackWithFiveElements.pop());
        assertEquals("B", stackWithFiveElements.pop());
        assertEquals("A", stackWithFiveElements.pop());

        assertTrue(stackWithFiveElements.size() == 0);
        assertEquals("C", stackWithZeroElements.pop());
        assertEquals("B", stackWithZeroElements.pop());
        assertEquals("A", stackWithZeroElements.pop());
        assertTrue(stackWithZeroElements.size() == 0);

    }
}