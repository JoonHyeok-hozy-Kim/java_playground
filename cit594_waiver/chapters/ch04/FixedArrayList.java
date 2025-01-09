package cit594_waiver.chapters.ch04;

public class FixedArrayList<E> implements List<E>{

    // keeping the instance variables package private
    // to make testing easier.
    Object[] array;
    int allocationSize;
    int size;

    final int DEFAULT_CAPACITY = 10;

    public FixedArrayList(int initialCapacity) {
        allocationSize = initialCapacity;
        size = 0;
        array = new Object[initialCapacity];
    }

    public FixedArrayList() {
        allocationSize = DEFAULT_CAPACITY;
        size = 0;
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        if (size == allocationSize) {
            return false;
        }
        array[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        if (size == allocationSize) {
            return false;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Must have index >= 0 && index < size");
        }
        return (E) array[index];
    }

    @Override
    public E remove(int index) {
        E toRemove = (E) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return toRemove;
    }

    @Override
    public boolean remove(Object o) {
        int targetIndex = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1) {
            return false;
        }

        remove(targetIndex);
        return true;
    }

    @Override
    public int size() {
        return size;
    }
}
