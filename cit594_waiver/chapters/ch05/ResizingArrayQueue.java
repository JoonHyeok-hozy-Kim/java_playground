package cit594_waiver.chapters.ch05;

public class ResizingArrayQueue<E> implements Queue<E> {
    private Object[] array;
    private int frontIndex;
    private int size;

    public ResizingArrayQueue() {
        this(-1);
    }

    public ResizingArrayQueue(int maximumLength) {
        int allocationSize = (0 == maximumLength) ? 0 : 1;
        array = new Object[allocationSize];
        size = 0;
        frontIndex = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean offer(E e) {
        // Resize if length equals allocation size
        if (size == array.length) {
            resize();
        }

        // Enqueue the item and return true
        int itemIndex = (frontIndex + size) % array.length;
        array[itemIndex] = e;
        size++;
        return true;
    }

    @Override
    public E peek() {
        return (E) array[frontIndex];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    public E poll() {
        // Get the item at the front of the queue
        E toReturn = (E) array[frontIndex];

        // Decrement length and advance frontIndex
        size--;
        frontIndex = (frontIndex + 1) % array.length;

        // Return the front item
        return toReturn;
    }

    private void resize() {
        // Allocate new array and copy existing items
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < size; i++) {
            int itemIndex = (frontIndex + i) % array.length;
            newArray[i] = array[itemIndex];
        }

        // Assign new array and reset frontIndex to 0
        array = newArray;
        frontIndex = 0;
    }
}
