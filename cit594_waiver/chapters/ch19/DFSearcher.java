package cit594_waiver.chapters.ch19;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class DFSearcher implements SearchStrategy {

    @Override
    public Queue<Vertex> frontierQueue() {
        return Collections.asLifoQueue(new ArrayDeque<>());
    }
}
