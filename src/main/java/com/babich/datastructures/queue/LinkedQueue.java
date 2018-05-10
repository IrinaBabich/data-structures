package com.babich.datastructures.queue;

public class LinkedQueue {
    Node head;
    int size;

    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Object dequeue() {
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    private static class Node {
        private Node next;
        private Object value;

        Node(Object value) {
            this.value = value;
        }
    }
}
