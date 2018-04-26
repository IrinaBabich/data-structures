package com.babich.datastructures.stack;
import java.util.NoSuchElementException;

public class ArrayStack{
    int size;
    Object[] array;

    public ArrayStack(int capacity){
        array = new Object[capacity];
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

    public Object poll(){
        validateSize();
        Object element=array[--size];
        array[size]=null;
        return element;
    }

    public Object peek(){
        validateSize();
        return array[size - 1];
    }

    public void validateSize() {
        if (size == 0) {
        throw new NoSuchElementException("Stack is empty");
        }
    }
}
