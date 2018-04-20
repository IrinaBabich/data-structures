package com.babich.datastructures.list;

public interface List {
    void add(Object object);
    void add(Object object, int index);
    Object remove(int index);
    Object get(int index);
    Object set(Object object, int index);
    void clear();
    int size();
    boolean isEmpty();
    boolean contains(Object object);
    int indexOf(Object object);
    int lastIndexOf(Object object);
    String toString();
}