package cit594_waiver.chapters.ch19;

public class Vertex implements Comparable<Vertex> {
    public String label;

    public Vertex(String vertexLabel) {
        label = vertexLabel;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vertex other){
        return this.label.compareTo(other.label);
    }
}
