package com.babich.datastructures.queue;

public interface Queue {
    void enqueue (Object value);

    Object dequeue();

    int size();
}
