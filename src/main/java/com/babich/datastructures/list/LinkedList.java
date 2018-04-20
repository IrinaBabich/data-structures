package com.babich.datastructures.list;

public class LinkedList implements List {
    Node head;
    int size;

    public void add(Object element) {
        add(size(), element);
    }

    public void add(int index, Object element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid size!");
        }
    }

