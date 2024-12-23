package cit594_waiver.chapters.ch19;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSearcher implements SearchStrategy {
    @Override
    public Queue<Vertex> frontierQueue() {
        ArrayDeque<Vertex> dq = new ArrayDeque<>();
        return dq;
    }
}
