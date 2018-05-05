package com.babich.datastructures.stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayStackTest extends AbstractStackTest {
    public ArrayStack getStack() {
        return new ArrayStack();
    }
}