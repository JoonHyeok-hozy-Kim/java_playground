package cit594_waiver.chapters.ch04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResizingArrayListTest {

    @Test
    public void testAdd() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(2);
        l.add(4);

        Integer[] expected = {1, 2, 4, null};
        Object[] actual = l.array;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOutOfCapacity() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(2);
        l.add(4);
        l.add(8);
        l.add(16);

        Integer[] expected = {1, 2, 4, 8, 16, null, null, null};
        Object[] actual = l.array;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddByIndex() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(0, 2);

        Integer[] expected = {2, 1, null, null};
        Object[] actual = l.array;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void get() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(0, 2);
        l.add(1, 4);

        assertEquals(Integer.valueOf(2), l.get(0));
        assertEquals(Integer.valueOf(4), l.get(1));
        assertEquals(Integer.valueOf(1), l.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIAE() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(0, 2);

        l.get(2);
    }

    @Test
    public void remove() {
        ResizingArrayList<Integer> l = new ResizingArrayList<>(4);
        l.add(1);
        l.add(2);
        l.add(4);

        l.remove(1);

        Integer[] expected = {1, 4, null, null};
        Object[] actual = l.array;
        assertArrayEquals(expected, actual);

        l.remove(0);
        expected = new Integer[] {4, null, null, null};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        ResizingArrayList<String> l = new ResizingArrayList<>(4);
        l.add("Hello");
        l.add("Goodbye");
        l.add("Indeed");
        l.remove("Hello");

        String[] expected = {"Goodbye", "Indeed", null, null};
        Object[] actual = l.array;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void size() {
        ResizingArrayList<String> l = new ResizingArrayList<>(4);
        l.add("Hello");
        l.add("Goodbye");
        l.add("Indeed");
        l.remove("Hello");
        l.add("Heya");
        l.remove(0);

        assertEquals(2, l.size());
    }
}