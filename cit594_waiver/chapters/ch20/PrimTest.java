package cit594_waiver.chapters.ch20;

import cit594_waiver.chapters.ch19.Graph;
import cit594_waiver.chapters.ch19.Vertex;
import cit594_waiver.chapters.ch19.Edge;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;

public class PrimTest {
    private Graph g;

    private Vertex a;
    private Vertex b;
    private Vertex c;
    private Vertex d;
    private Vertex e;
    private Vertex f;

    private Edge[] e1;
    private Edge[] e2;
    private Edge[] e3;
    private Edge[] e4;
    private Edge[] e5;
    private Edge[] e6;
    private Edge[] e7;
    private Edge[] e8;

    @Before
    public void setup(){
        g = new Graph();

        a = g.addVertex("A");
        b = g.addVertex("B");
        c = g.addVertex("C");
        d = g.addVertex("D");
        e = g.addVertex("E");
        f = g.addVertex("F");
    
        e1 = g.addUndirectedEdge(a, c, 7);
        e2 = g.addUndirectedEdge(a, e, 9);
        e3 = g.addUndirectedEdge(b, c, 5);
        e4 = g.addUndirectedEdge(b, f, 6);
        e5 = g.addUndirectedEdge(c, d, 1);
        e6 = g.addUndirectedEdge(c, f, 2);
        e7 = g.addUndirectedEdge(d, f, 2);
        e8 = g.addUndirectedEdge(e, f, 1);
    }

    @Test
    public void NodeCountTest(){        
        assertEquals("Total 6 nodes", 6, g.nodeCount());
    }

    @Test
    public void NodeCountWithPrimTest(){
        PrimAlgorithm p = new PrimAlgorithm();
        Graph MCST = p.getMCST(g, a);

        assertEquals("Node number equals", g.nodeCount(), MCST.nodeCount());
    }
}
