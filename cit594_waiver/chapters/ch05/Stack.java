package cit594_waiver.chapters.ch05;

import java.util.EmptyStackException;

public interface Stack<E> {

    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean empty();

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the object at the top of this stack
     * @throws EmptyStackException - if this stack is empty.
     */
    public E peek();

    /**
     * Looks at the object at the top of this stack and removes it from the stack.
     * @return the object at the top of this stack
     * @throws EmptyStackException - if this stack is empty.
     */
    public E pop();

    /**
     * Pushes an item onto the top of this stack.
     * @param item the item to be pushed on the stack
     * @return the item argument
     */
    public E push(E item);


}
