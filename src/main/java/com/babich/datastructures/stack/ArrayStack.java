package com.babich.datastructures.stack;
import java.util.NoSuchElementException;

public class ArrayStack extends AbstractStack{
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

    private void resize(){
        Object[] newArray = new Object[(int)(1.5 * array.length)];

        System.arraycopy(array,0,newArray,0,size);
        array=newArray;
    }

    public Object pop(){
        validateSize();
        Object element=array[size - 1];
        size--;
        return element;
    }

    public Object peek(){
        validateSize();
        return array[size - 1];
    }

    public int size() {
        return size;

    }
    public void validateSize() {
        if (size == 0) {
        throw new NoSuchElementException("Stack is empty");
        }
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i != size - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
}
