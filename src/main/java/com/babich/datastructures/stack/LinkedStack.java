package com.babich.datastructures.stack;
import java.util.NoSuchElementException;

public class LinkedStack extends AbstractStack{
    int size;
    Node last;

    public void push(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            last = newNode;
        } else {
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public Object peek() {

        if (size == 0) {
            throw new NoSuchElementException("Method peek(): stack is empty");
        }
        return last.value;
    }

    public Object pop() {
        if (size == 0 || last == null) {
            throw new NoSuchElementException("Method pop(): stack is empty");
        } else {
            Object object = last.value;
            last = last.prev;
            size--;
            return object;
        }
    }

    public int size() {
        return size;
    }
}