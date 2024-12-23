package cit594_waiver.chapters.ch19;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQSearcher implements SearchStrategy {
    @Override
    public Queue<Vertex> frontierQueue() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        return pq;
    }
}
