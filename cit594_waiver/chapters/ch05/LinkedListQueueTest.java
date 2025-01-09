package cit594_waiver.chapters.ch05;
import org.junit.Test;
import cit594_waiver.chapters.ch05.LinkedListQueue;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListQueueTest {

    @Test
    public void empty() {
        Queue<String> s = new LinkedListQueue<>();
        assertTrue(s.empty());
    }

    @Test
    public void emptyAfterPush() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        assertFalse(s.empty());
    }

    @Test
    public void emptyAfterPushPop() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        s.poll();
        assertTrue(s.empty());
    }

    @Test
    public void peekReturnsCorrect() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        s.offer("Yes, you!");
        String top = s.peek();
        assertEquals("Hello!", top);
    }

    @Test
    public void peekDoesntModify() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        s.offer("Yes, you!");
        s.peek();
        String top = s.peek();
        assertEquals("Hello!", top);
    }

    @Test(expected = NoSuchElementException.class)
    public void peekOnEmpty() {
        Queue<String> s = new LinkedListQueue<>();
        String top = s.peek();
    }

    @Test
    public void popReturnsCorrect() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        s.offer("Yes, you!");
        String top = s.poll();
        assertEquals("Hello!", top);
    }

    @Test
    public void popDoesModify() {
        Queue<String> s = new LinkedListQueue<>();
        s.offer("Hello!");
        s.offer("Yes, you!");
        s.poll();
        String top = s.peek();
        assertEquals("Yes, you!", top);
    }

}