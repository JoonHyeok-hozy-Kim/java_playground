package cit594_waiver.chapters.ch05;

import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {


    private Node head;
    private Node tail;
    private int size;

    @Override
    public E poll() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        E toReturn = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return toReturn;
    }

    @Override
    public boolean offer(E e) {
        if (head == null) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean empty() {
        return size == 0;
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
