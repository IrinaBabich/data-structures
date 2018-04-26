package com.babich.datastructures.queue;

public class ArrayQueue implements Queue {
        private static final int DEFAULT_CAPACITY = 5;

        Object[] array;
        int size;
        int start;

        public ArrayQueue() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayQueue(int capacity) {
            this.array = new Object[capacity];
        }

        public void enqueue(Object value) {
            if (array.length == size) {
                throw new RuntimeException("Queue overflow");
            }
            int indexToInsert = start + size;

            if (indexToInsert == array.length) {
                for (int i = 0; i < size; i++) {
                    array[i] = array[start + i];
                    array[start + i] = null;
                }
                start = 0;
                indexToInsert = start + size;
            }

            array[indexToInsert] = value;
            size++;
        }

        public Object dequeue() {
            if (size == 0) {
                throw new RuntimeException("Queue is empty");
            }
            Object result = array[start];
            array[start] = null;
            start++;
            size--;
            return result;
        }
        public int size() {
            return size;
        }
    }

