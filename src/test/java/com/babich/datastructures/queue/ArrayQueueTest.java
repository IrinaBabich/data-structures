package com.babich.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

        @Test
        public void testEnqueueAndDequeue() {
            ArrayQueue arrayQueue = new ArrayQueue();
            String[] values = {"A", "B", "C"};

            for (String value : values) {
                arrayQueue.enqueue(value);
            }
            assertEquals(3, arrayQueue.size());

            for (String value : values) {
                Object actual = arrayQueue.dequeue();
                assertEquals(value, actual);
            }
            assertEquals(0, arrayQueue.size());
        }
    }