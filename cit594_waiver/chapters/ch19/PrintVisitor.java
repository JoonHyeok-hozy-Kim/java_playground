package cit594_waiver.chapters.ch19;

public class PrintVisitor implements VertexVisitor {
    @Override
    public void visit(Vertex toVisit) {
        System.out.println(toVisit);
    }
}
