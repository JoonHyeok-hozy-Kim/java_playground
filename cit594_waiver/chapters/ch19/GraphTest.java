package cit594_waiver.chapters.ch19;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {

    private Graph g;
    private Vertex joe;
    private Vertex taj;
    private Vertex chen;
    private Vertex eva;
    private Vertex lily;
    private Vertex jun;
    private Vertex ken;

    @Before
    public void setup() {
        g = new Graph();
        joe = g.addVertex("Joe");
        taj = g.addVertex("Taj");
        chen = g.addVertex("Chen");
        eva = g.addVertex("Eva");
        lily = g.addVertex("Lily");
        jun = g.addVertex("Jun");
        ken = g.addVertex("Ken");

        g.addUndirectedEdge(joe, eva, 1);
        g.addUndirectedEdge(joe, taj, 3);
        g.addUndirectedEdge(eva, lily, 2);
        g.addUndirectedEdge(taj, lily, 5);
        g.addUndirectedEdge(taj, chen, 3);
        g.addUndirectedEdge(lily, jun, 4);
        g.addUndirectedEdge(chen, jun, 9);
        g.addUndirectedEdge(jun, ken, 2);
    }

    @Test
    public void BFSTest(){
        System.out.println("[BFS Test]");
        // g.search(joe, new PrintVisitor());

        assertEquals("Total 7 nodes", 7, g.nodeCount());
    }

    public void DFSTest(){
        System.out.println("[DFS Test]");
        g.setSearcher(new DFSearcher());

        assertEquals("Total 7 nodes", 7, g.nodeCount());
    }

    public void AlphaTest(){
        System.out.println("[Alpha Test]");
        g.search(joe, v -> v.label = v.label.toUpperCase());
        
        assertEquals("JOE", joe.label);
    }

    public void PQTest(){
        System.out.println("[PQ Test]");
        g.setSearcher(new PQSearcher());
        g.search(joe, new PrintVisitor());

        assertEquals("Total 7 nodes", 7, g.nodeCount());
    }
}
