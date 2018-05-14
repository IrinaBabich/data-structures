package com.babich.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList extends AbstractList implements Iterable{
    private static final int INITIAL_CAPACITY = 5;
    private Object[] array;


    public ArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public void add(Object value, int index) {
        validateAddIndex(index);
        if (size == array.length) {
            resize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    private void resize() {
        Object temp[] = new Object[(int) (array.length * 1.5) + 1];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    public Object remove(int index) {
        validateIndex(index);
        Object removeElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return removeElement;

    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Object oldElement = array[index];
        array[index] = value;
        return oldElement;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(array[i]));
        }
        return String.valueOf(result);
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < array.length && array[currentIndex] != null;
        }

        @Override
        public Object next() {
            return array[currentIndex++];
        }
    }
}

class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        for (Object o : list){
            System.out.println(o);
        }
    }
}

