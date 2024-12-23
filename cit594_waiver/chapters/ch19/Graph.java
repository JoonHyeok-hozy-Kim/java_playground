package cit594_waiver.chapters.ch19;

import java.util.*;

public class Graph {

    // Maps a vertex to an ArrayList of all edges that start from that vertex
    private final HashMap<Vertex, ArrayList<Edge>> fromEdges;

    // Maps a vertex to an ArrayList of all edges that go to that vertex
    private final HashMap<Vertex, ArrayList<Edge>> toEdges;

    private SearchStrategy searcher = new BFSearcher();

    public Graph() {
        fromEdges = new HashMap<>();
        toEdges = new HashMap<>();
    }

    public void setSearcher(SearchStrategy searcher) {
        this.searcher = searcher;
    }

    // Returns a collection of all edges in the graph
    public Collection<Edge> getEdges() {
        HashSet<Edge> edges = new HashSet<>();
        for (ArrayList<Edge> edgeList : fromEdges.values()) {
            edges.addAll(edgeList);
        }
        return edges;
    }

    // Returns the collection of edges with the specified fromVertex
    public Collection<Edge> getEdgesFrom(Vertex fromVertex) {
        return fromEdges.get(fromVertex);
    }

    // Returns the collection of edges with the specified toVertex
    public Collection<Edge> getEdgesTo(Vertex toVertex) {
        return toEdges.get(toVertex);
    }

    // Returns a vertex with a matching label, or null if no such vertex exists
    public Vertex getVertex(String vertexLabel) {
        // Search the collection of vertices for a vertex with a matching label
        for (Vertex vertex : getVertices()) {
            if (vertex.label.equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    // Returns the collection of all of this graph's vertices
    public Collection<Vertex> getVertices() {
        return fromEdges.keySet();
    }

    public Vertex addVertex(String newVertexLabel) {
        // Create the new Vertex object
        Vertex newVertex = new Vertex(newVertexLabel);

        // Every vertex must exist as a key in both maps
        fromEdges.put(newVertex, new ArrayList<>());
        toEdges.put(newVertex, new ArrayList<>());

        return newVertex;
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
        // Don't add the same edge twice
        if (hasEdge(fromVertex, toVertex)) {
            return null;
        }

        // Create the Edge object
        Edge newEdge = new Edge(fromVertex, toVertex, weight);

        // Add the edge to the appropriate list in both maps
        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);

        return newEdge;
    }

    public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB, double weight) {
        Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
        Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
        return new Edge[]{ edge1, edge2 };
    }

    // Returns true if this graph has an edge from fromVertex to toVertex
    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        if (!fromEdges.containsKey(fromVertex)) {
            // fromVertex is not in this graph
            return false;
        }

        // Search the list of edges for an edge that goes to toVertex
        ArrayList<Edge> edges = fromEdges.get(fromVertex);
        for (Edge edge : edges) {
            if (edge.toVertex == toVertex) {
                return true;
            }
        }

        return false;
    }

    public List<Vertex> search(Vertex start, VertexVisitor visitor) {
        Set<Vertex> discovered = new HashSet<>();
        Queue<Vertex> frontierQueue = searcher.frontierQueue();
        List<Vertex> visited = new ArrayList<>();

        frontierQueue.add(start);
        discovered.add(start);
        while (!frontierQueue.isEmpty()) {
            Vertex current = frontierQueue.remove();
            visited.add(current);
            visitor.visit(current);
            for (Edge e : getEdgesFrom(current)) {
                Vertex adjacent = e.toVertex;
                if (!discovered.contains(adjacent)) {
                    frontierQueue.add(adjacent);
                    discovered.add(adjacent);
                }
            }
        }
        return visited;
    }
}
