package com.babich.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class ArrayStackTest {

    ArrayStack stackWithZeroElements;
    ArrayStack stackWithFiveElements;
    int size;

    @Before
    public void before() {
        stackWithZeroElements = new ArrayStack();
        stackWithFiveElements = new ArrayStack(5);

        char c = 'A';
        for (int i = 0; i < size; i++) {
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
        stackWithFiveElements.push("F");

        assertEquals("C", stackWithZeroElements.peek());
        assertEquals("C", stackWithZeroElements.pop());
        assertEquals("B", stackWithZeroElements.pop());
        assertEquals("A", stackWithZeroElements.peek());
        assertEquals("A", stackWithZeroElements.pop());
        assertEquals("F", stackWithFiveElements.pop());
    }

    @Test
    public void testPeek() {
        stackWithZeroElements.push("A");
        assertEquals("A", stackWithZeroElements.peek());
        assertEquals("E", stackWithFiveElements.peek());
        stackWithFiveElements.pop();
        assertEquals("D", stackWithFiveElements.peek());
        stackWithFiveElements.push(1);
        stackWithFiveElements.push(2);
        assertEquals(2, stackWithFiveElements.peek());
        assertTrue(stackWithFiveElements.peek().equals(2));
        assertFalse(stackWithFiveElements.peek().equals("2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekException() {
        stackWithZeroElements.peek();
    }

    @Test
    public void testPop() {
        stackWithZeroElements.push("A");
        stackWithZeroElements.push("B");
        stackWithZeroElements.push("C");

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

    @Test(expected = NoSuchElementException.class)
    public void testPopException() {
        stackWithZeroElements.pop();
    }

}