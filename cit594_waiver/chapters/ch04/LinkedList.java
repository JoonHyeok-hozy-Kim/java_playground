package cit594_waiver.chapters.ch04;

public class LinkedList<E> implements List<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Must have index >= 0 && index <= size");
        }
        if (index == size) {
            add(e);
            return true;
        }

        Node newSuccessor = node(index);
        Node newNode = new Node(e);
        newNode.next = newSuccessor;
        newNode.prev = newSuccessor.prev;
        newSuccessor.prev = newNode;
        newNode.prev.next = newNode;
        return true;
    }

    private Node node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Must have index >= 0 && index < size");
        }

        return node(index).data;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Must have index >= 0 && index < size");
        }

        Node toRemove = node(index);
        E element = toRemove.data;
        Node next = toRemove.next;
        Node prev = toRemove.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            toRemove.prev = null; // help with garbage collection
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            toRemove.next = null; // help with garbage collection
        }

        toRemove.data = null; // gc
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        Node toRemove = head;
        for (int i = 0; i < size; i++) {
            if (toRemove.data.equals(o)) {
                index = i;
                break;
            }
            toRemove = toRemove.next;
        }
        if (index == -1) {
            return false;
        }
        toRemove = node(index);
        E element = toRemove.data;
        Node next = toRemove.next;
        Node prev = toRemove.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            toRemove.prev = null; // help with garbage collection
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            toRemove.next = null; // help with garbage collection
        }

        toRemove.data = null; // gc
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }



    class Node {
        public E data;
        public Node next;
        public Node prev;

        public Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

//    public static void main(String[] args) {
//        List<Integer> l = new LinkedList<>();
//    }
}
