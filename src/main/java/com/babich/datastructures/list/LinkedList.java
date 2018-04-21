package com.babich.datastructures.list;

public class LinkedList implements List{

    //add links to the first and last node
    private LinkedList head;
    private LinkedList tail;

    //add element to the end of list
    public void add(Object object) {
        LinkedList node = new LinkedList(Object object);

        // if list is empty
        if (head == null) {
            head = node;
            tail = node;
            // if list is not empty,
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //remove node from the list
    public boolean remove(Object object) {
        LinkedList previous = null;
        LinkedList current = head;

        // 1) if the list is empty do nothing
        // 2) if there is one element in the list then previous = null
        // 3) if there are several elements:
        //    - deleted element could be the first
        //    - deleted element could be in the middle of list or in the end

        while (current != null) {
            if (current.value.equals(object)) {
                // deleted node is in the middle or in the end
                if (previous != null) {
                    // Before:    Head -> 3 -> 5 -> null
                    // After:     Head -> 3 ------> null
                    previous.next = current.next;

                    // if node is in the end, then change tail
                    if (current.next == null) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    // if the list is empty
                    if (head == null) {
                        tail = null;
                    }
                }
                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }
        return false;
    }

    // check every element of the list from the first to last, true if we find element, false if don't
    public boolean contains(Object object) {
        LinkedList current = head;
        while (current != null) {
            if (current.value.Equals(object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // list is empty if head and tail equals null
    public void clear(Object object) {
        head = null;
        tail = null;
        size = 0;
    }

    //copy elements of list to the array (by indexes)
    public void copy(Object[] array, int arrayIndex) {
        LinkedList current = head;
        while (current != null) {
            array[arrayIndex++] = current.value;
            current = current.next;
        }
    }
}

//
//    private void validateIndex(int index) {
//        if (index >= size || index < 0) {
//            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + size);
//        }
//    }
//}
