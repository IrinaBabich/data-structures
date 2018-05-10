package com.babich.datastructures.stack;

public interface Stack {
    void push(Object value);
    Object peek();
    Object pop();
    int size();
    String toString();
}