package com.babich.datastructures.list;

public class LinkedList implements List {

    Node head;
    Node tail;
    int size;

   public Object get(int index){
        validateIndex(index);
        return getNode(index).value;
   }

   public void add(Object value) {
        add(value, size);
   }

    public void add(Object value, int index) {
        validateIndex(index);
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
        Node current = head;

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

        private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + size);
        }
    }

    public String toString() {
        Node newNode = head;
        String result = "";
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                result += newNode.value + ", ";
                newNode = newNode.next;
            }
            result += newNode.value;
        }
        return "[" + result + "]";
    }


}