package com.babich.datastructures.list;

public abstract class LinkedList implements List {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {

            if (size == 1) {
                head.next = newNode;
                newNode.prev = head;
                tail = newNode;

            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        size++;
    }

    public void add(Object value, int index) {
        indexValidation(index);
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
        indexValidation(index);
        Node curNode = getNode(index);
        Object valueToRemove = curNode.value;

        if (size == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            curNode.next.prev = curNode.prev;
            curNode.prev.next = curNode.next;
        }
        size--;
        return valueToRemove;
    }

    public Object getNode(int index) {
        indexValidation(index);
        return getNode(index).value;
    }

    public Object set(Object value, int index) {
        indexValidation(index);
        Node curNode = getNode(index);
        Object oldValue = curNode.value;
        curNode.value = value;
        return oldValue;
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int indexOf(Object value) {
        Node curHead = head;

        for (int i = 0; i <= size - 1; i++) {
            if (value.equals(curHead.value)) {
                return i;
            }
            curHead = curHead.next;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        Node curNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.prev;
        }
        return -1;
    }

    public String toString() {
        Node cur = head;
        String result = "[";

        for (int i = 0; i <= size - 1; i++) {
            if (i == size - 1) {
                result += cur.value;
            } else {
                result += cur.value + ", ";
                cur = cur.next;
            }
        }
        result += "]";

        return result;
    }

    private void indexValidation(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + size);
        }
    }
}