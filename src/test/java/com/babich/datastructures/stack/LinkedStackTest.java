
package com.babich.datastructures.stack;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

    public class LinkedStackTest extends AbstractStackTest {

        public LinkedStack getStack() {
            return new LinkedStack();
        }
    }