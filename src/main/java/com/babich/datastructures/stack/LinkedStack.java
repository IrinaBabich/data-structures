package com.babich.datastructures.stack;
import java.util.NoSuchElementException;

public class LinkedStack {
    int size;
    Node head;


    public void push(Object value) {
        Node lastNode = getLastNode();
        lastNode.next = new Node(value);
        size++;
    }

    public Object peek() {
        validateSize();
        return getLastNode().value;
    }

    private Node getLastNode() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public Object pop() {
        validateSize();
        Node temp = head;
        size--;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
        }

        Node last = temp.next;
        temp.next = null;

        return last.value;
    }

    protected void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
    }
}


