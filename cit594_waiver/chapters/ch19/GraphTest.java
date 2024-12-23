package cit594_waiver.chapters.ch19;

public class GraphTest {

    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex joe = g.addVertex("Joe");
        Vertex taj = g.addVertex("Taj");
        Vertex chen = g.addVertex("Chen");
        Vertex eva = g.addVertex("Eva");
        Vertex lily = g.addVertex("Lily");
        Vertex jun = g.addVertex("Jun");
        Vertex ken = g.addVertex("Ken");

        g.addUndirectedEdge(joe, eva, 1);
        g.addUndirectedEdge(joe, taj, 3);
        g.addUndirectedEdge(eva, lily, 2);
        g.addUndirectedEdge(taj, lily, 5);
        g.addUndirectedEdge(taj, chen, 3);
        g.addUndirectedEdge(lily, jun, 4);
        g.addUndirectedEdge(chen, jun, 9);
        g.addUndirectedEdge(jun, ken, 2);

        // // search the default way, using BFS
        BFSTest(g, joe);

        // // search a new way, using DFS
        DFSTest(g, joe);

        // // what about a new visitor that changes the labels of the vertices it sees?
        AlphaTest(g, joe);

        // what about a new Strategy that always explores the next vertex in the frontier based on the
        // alphabetical ordering of their titles??
        // g.setSearcher(???);
        PQTest(g, joe);
    }

    public static void BFSTest(Graph g, Vertex start){
        System.out.println("[BFS Test]");
        g.search(start, new PrintVisitor());
    }

    public static void DFSTest(Graph g, Vertex start){
        System.out.println("[DFS Test]");
        g.setSearcher(new DFSearcher());
        g.search(start, new PrintVisitor());
    }

    public static void AlphaTest(Graph g, Vertex start){
        System.out.println("[Alpha Test]");
        g.search(start, v -> v.label = v.label.toUpperCase());
        g.search(start, new PrintVisitor());
    }

    public static void PQTest(Graph g, Vertex start){
        System.out.println("[PQ Test]");
        g.setSearcher(new PQSearcher());
        g.search(start, new PrintVisitor());
    }
}
