package cit594_waiver.chapters.ch05;

import java.util.EmptyStackException;

public class ResizingArrayStack<E> implements Stack<E> {

    private Object[] array;
    private int length;

    private final static int DEFAULT_CAPACITY = 16;

    public ResizingArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    public ResizingArrayStack(int capacity) {
        array = new Object[capacity];
        length = 0;
    }

    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public boolean empty() {
        return length == 0;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return (E) array[length - 1];
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E item = (E) array[length - 1];
        length--;
        return item;
    }

    @Override
    public E push(E item) {
        if (length == array.length) {
            grow();
        }
        array[length] = item;
        length++;
        return item;
    }
}
