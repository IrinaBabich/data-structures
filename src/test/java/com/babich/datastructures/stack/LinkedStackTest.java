
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

//        @Test
//        public void testPopUntilEmpty() {
//            List<Object> values = Arrays.asList(40, 60, 150, 20);
//            LinkListStack<Object> stack = new LinkListStack<>();
//            assertTrue(stack.isEmpty());
//            for (Object value : values) {
//
//
//                stack.push(value);
//            }
//            assertFalse(stack.isEmpty());
//            for (int i = values.size(); i > 0; --i) {
//                assertEquals(values.get(i - 1), stack.pop());
//            }
//            assertTrue(stack.isEmpty());
//        }
    }
