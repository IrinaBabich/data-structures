package com.babich.datastructures.list;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {

    private Node head;
    private Node tail;

   public Object get(int index){
        validateAddIndex(index);
        return getNode(index).value;
   }

   public void add(Object value) {
        add(value, size);
   }

    public void add(Object value, int index) {
        validateAddIndex(index);
        Node newNode = new Node(value);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {

            Node curNode = getNode(index);

            newNode.prev = curNode.prev;
            newNode.next = curNode;
            curNode.prev.next = newNode;
            curNode.prev = newNode;
        }
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);

        Node curNode;

        if (size == 1) {
            curNode = head;
            head = tail = null;
        } else if (index == 0) {
            curNode = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            curNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            curNode = getNode(index);
            curNode.next.prev = curNode.prev;
            curNode.prev.next = curNode.next;
        }
        size--;
        return curNode.value;
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Node curNode = getNode(index);
        Object oldValue = curNode.value;
        curNode.value = value;
        return oldValue;
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }

    public int indexOf(Object value) {
        Node current = head;
        if (value == null) {
            throw new NullPointerException("Value can not be null");
        }
        for (int i = 0; i < size; i++) {
            if (value.equals(current.value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        Node current = tail;
        if (value == null) {
            throw new NullPointerException("Value can not be null");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (current.value.equals(value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    private Node getNode(int index) {
        Node curNode;
        if (index >= size / 2) {
            curNode = tail;
            for (int i = size; i > index + 1; i--) {
                curNode = curNode.prev;
            }
        } else {
            curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
        }

        return curNode;
    }

    public String toString () {
        StringJoiner result = new StringJoiner(",", "[", "]");
        Node current = head;
        for (int i = 0; i < size; i++) {
            result.add(String.valueOf(current.value));
            current = current.next;
        }
        return String.valueOf(result);
    }

    private static class Node {
        private Node next;
        private Node prev;
        private Object value;

        Node(Object value)
        {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }
}

