package cit594_waiver.chapters.ch20;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import cit594_waiver.chapters.ch19.Edge;
import cit594_waiver.chapters.ch19.Graph;
import cit594_waiver.chapters.ch19.Vertex;

public class PrimAlgorithm {
    public Graph getMCST(Graph originalGraph, Vertex originalStart){
        Graph MCST = new Graph();
        
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>();
        Set<Vertex> visitedVertices = new HashSet<>();
        Set<Edge> visitedEdges = new HashSet<>();

        visitedVertices.add(originalStart);
        for (Edge e : originalGraph.getEdgesFrom(originalStart)){
            edgePriorityQueue.add(e);
        }
        
        Edge currEdge;
        while (!edgePriorityQueue.isEmpty()){
            currEdge = edgePriorityQueue.poll();
            if (visitedVertices.contains(currEdge.toVertex)) continue;

            copyEdge(MCST, currEdge);
            visitedEdges.add(currEdge);
            visitedVertices.add(currEdge.toVertex);
            for (Edge e : originalGraph.getEdgesFrom(currEdge.toVertex)){
                edgePriorityQueue.add(e);
            }
        }

        return MCST;
    }

    public void copyEdge(Graph g, Edge e){
        Vertex f_vertex = g.getVertex(e.fromVertex.label);
        if (f_vertex == null){
            f_vertex = g.addVertex(e.fromVertex.label);
        }

        Vertex t_vertex = g.getVertex(e.toVertex.label);
        if (t_vertex == null){
            t_vertex = g.addVertex(e.toVertex.label);
        }

        g.addUndirectedEdge(f_vertex, t_vertex, e.weight);
        return;
    }
}
