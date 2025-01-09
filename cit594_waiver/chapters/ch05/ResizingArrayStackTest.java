package cit594_waiver.chapters.ch05;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class ResizingArrayStackTest {

    @Test
    public void empty() {
        Stack<String> s = new ResizingArrayStack<>();
        assertTrue(s.empty());
    }

    @Test
    public void emptyAfterPush() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        assertFalse(s.empty());
    }

    @Test
    public void emptyAfterPushPop() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        s.pop();
        assertTrue(s.empty());
    }

    @Test
    public void peekReturnsCorrect() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        s.push("Yes, you!");
        String top = s.peek();
        assertEquals("Yes, you!", top);
    }

    @Test
    public void peekDoesntModify() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        s.push("Yes, you!");
        s.peek();
        String top = s.peek();
        assertEquals("Yes, you!", top);
    }

    @Test(expected = EmptyStackException.class)
    public void peekOnEmpty() {
        Stack<String> s = new ResizingArrayStack<>();
        String top = s.peek();
    }

    @Test
    public void popReturnsCorrect() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        s.push("Yes, you!");
        String top = s.pop();
        assertEquals("Yes, you!", top);
    }

    @Test
    public void popDoesModify() {
        Stack<String> s = new ResizingArrayStack<>();
        s.push("Hello!");
        s.push("Yes, you!");
        s.pop();
        String top = s.peek();
        assertEquals("Hello!", top);
    }

}