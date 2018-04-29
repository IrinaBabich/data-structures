
package com.babich.datastructures.stack;
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedStackTest {

    @Test

    public void testPushAndPop() {
        LinkedStack stack = new LinkedStack();
        stack.push(40);
        stack.push(60);
        stack.push(150);
        assertEquals("150 60 40", stack.toString());
        assertEquals(150, stack.pop());
        assertEquals("60 40", stack.toString());
    }
}