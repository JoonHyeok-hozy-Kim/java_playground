package cit594_waiver.chapters.ch05;

import java.util.EmptyStackException;

public class LinkedListStack<E> implements Stack<E> {

    private Node head;
    private int size;


    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return head.data;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public E push(E item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
        return item;
    }

    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
