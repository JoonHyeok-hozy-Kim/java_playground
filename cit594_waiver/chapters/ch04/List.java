package cit594_waiver.chapters.ch04;

public interface List<E> {

    /**
     * Inserts e at the end of the list
     * @param e
     * @return true if the add is successful, false otherwise
     */
    public boolean add(E e);

    /**
     * Inserts e at the specified index
     * @param index
     * @param e
     * @return true if the add is successful, false otherwise
     * @throws IllegalArgumentException for indices outside of [0, size]
     */
    public boolean add(int index, E e);

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index);

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left
     * (subtracts one from their indices). Returns the element that was removed from the list.
     * @param index
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i
     * such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element
     * (or equivalently, if this list changed as a result of the call).
     * @param o
     * @return true if this list contained the specified element
     */
    public boolean remove(Object o);

    /**
     * Returns the number of elements in this list.
     * If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this list.
     */
    public int size();
}
