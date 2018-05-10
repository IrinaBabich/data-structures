package com.babich.datastructures.stack;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayStack extends AbstractStack {
    private static final int INITIAL_CAPACITY = 5;
    int size;
    Object[] array;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.array = new Object[capacity];
    }

    public void push(Object value) {
        if (array.length == size) {
            resize();
        }
        array[size] = value;
        size++;
    }

    private void resize() {
        Object[] newArray = new Object[(int) (1.5 * array.length) + 1];

        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public Object pop() {
        validateSize();
        Object element = array[size - 1];
        size--;
        return element;
    }

    public Object peek() {
        validateSize();
        return array[size - 1];
    }

    public void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(array[i]));
        }
        return String.valueOf(result);
    }
}
