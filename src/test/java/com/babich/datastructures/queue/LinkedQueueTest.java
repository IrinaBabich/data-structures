package com.babich.datastructures.queue;
import static org.junit.Assert.*;
import org.junit.Test;

    public class LinkedQueueTest {
        @Test
        public void testEnqueueAndDequeue() {
            LinkedQueue linkedQueue = new LinkedQueue();
            String[] values = {"A", "B", "C"};

            for (String value : values) {
                linkedQueue.enqueue(value);
            }
            assertEquals(3, linkedQueue.size());

            for (String value : values) {
                Object actual = linkedQueue.dequeue();
                assertEquals(value, actual);
            }
            assertEquals(0, linkedQueue.size());
        }

    }