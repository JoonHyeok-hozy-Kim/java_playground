package cit594_waiver.chapters.ch19;

public class Edge {
    public Vertex fromVertex;
    public Vertex toVertex;
    public double weight;

    public Edge(Vertex from, Vertex to, double weight) {
        fromVertex = from;
        toVertex = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + fromVertex +
                ", to=" + toVertex +
                ", weight=" + weight +
                '}';
    }
}
