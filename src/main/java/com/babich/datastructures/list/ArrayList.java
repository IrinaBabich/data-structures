package com.babich.datastructures.list;

public class ArrayList implements List {
    private static final int INITIAL_CAPACITY = 5;
    private int size;
    private Object objectArray[];


    public ArrayList(int capacity) {
        this.objectArray = new Object [capacity];
    }
    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public void add(Object object) {
        add(object, size);
    }

    public void add(Object object, int index) {
        if (size == objectArray.length) {
            resize();
        }
        for (int i = size(); i > index; i--) {
            objectArray[i] = objectArray[i-1];
        }
        objectArray[index] = object;
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);
        Object removeElement = objectArray[index];
        for (int i = index; i < size - 1; i++) {
            objectArray[i] = objectArray[i + 1];
        }
        size--;
        return removeElement;

    }

    public Object get(int index) {
        validateIndex(index);
        return objectArray[index];
    }
    public Object set(Object object, int index) {
        validateIndex(index);
        Object oldElement = objectArray[index];
        objectArray[index] = object;
        return oldElement;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            objectArray[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object object) {
        return indexOf(object) != 0;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (objectArray[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (objectArray[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    public void resize() {
        Object temp[] = new Object [(int) (objectArray.length*1.5)];
        for (int i = 0; i < size; i++) {
            temp[i] = objectArray[i];
        }
        objectArray = temp;
    }
    @Override
    public String toString() {
        String stringOutput = "Array List object [";
        for (int i = 0; i < size-1; i++) {
            stringOutput += objectArray[i] + ", ";
        }
        stringOutput = stringOutput + objectArray[size() - 1] + "]";
        return stringOutput;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + size);
        }
    }
}
