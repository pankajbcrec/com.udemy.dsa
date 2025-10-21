package com.udemy.dsa.graph;

import java.util.Objects;

public class Main {
public static void main(String[] args)
    {
        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        myGraph.addEdge("D", "A");
        myGraph.addEdge("D", "B");
        myGraph.addEdge("D", "C");

        myGraph.printGraph();
        myGraph.removeVertex("D");
        myGraph.printGraph();
    }
}
