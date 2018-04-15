package com.babich.datastructures.list;

public class ArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;

    private Object[] array;
    private int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    // adds given element at the end
    public void add(Object value) {
        add(value, size);
    }

    private void growCapacity() {
        Object[] newArray = new Object[(int) (array.length * 1.5)];
        for (int i = 0; i < 0; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // we can add value by index between [0, size]
    // otherwise throw new IndexOutOfBoundsException
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size + "(inclusive), but was : " + index);
            add(0, size);
        }

        // we can remove value by index between [0, size - 1]
        public Object remove (int index){
            validateIndex(index);
            Object valueToRemove = array[index];
            valueToRemove = null;
            return (Object value) valueToRemove;
        }

        // get element by index
        public Object get (int index) {
          validateIndex(index);
          return Object array[index];
        }

        // set (update) available element by index
        public Object set (T value, int index) {
            validateIndex(index);
            array[] index = (T) value;
            return value;
        }

        // [A, B, C] remove = 0
        public Object clear ( int index){
            for (int i = 0; i < size; i++)
                elementValue[i] = null;
            size = 0;
        }

        // [B (index = 0) , C (index = 1)]
        public Object remove (int index){
            checkIndex(index);
        }

        // void clear ();
        public void clear() {
           size = 0;
        }

        // int size ();
        public int size() {
            return size;
        }

        // boolean isEmpty ();
        public boolean isEmpty() {
           return size != 0;
        }

        // boolean contains (Object value);
        public boolean contains(Object value){
            return indexOf(value) != -1;
        }

        // int indexOf (Object value);
        public int indexOf(Object value){
            for (int i = 0; i < size; i++) ;
            if (array[i].equals(value)) {
                return i;
            }
        }
            return -1;
        }

        // int lastIndexOf (Object value);
        public int indexOf(Object value) {
            for (int i = 0; i < size; i++) {
                if ((value == null && get(i) == null) ||
                        (value != null && get(i).equals(value)))
                    return i;
            }
            return -1;
        }

        // [A, B, C], String toString
        public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            builder.append(array[i]).append(", ");
        }
        return builder.toString();
    }

        // validation
        private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }
}