package com.udemy.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Graph {
    private final HashMap<String, ArrayList<String>> adjList  =  new HashMap<>();

    public void printGraph(){
        System.out.println(adjList);
    }
    public boolean addVertex(String vertex){
        if(adjList.get(vertex)==null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(Optional.ofNullable(adjList.get(vertex1)).isPresent() && Optional.ofNullable(adjList.get(vertex2)).isPresent()){
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (Objects.nonNull(adjList.get(vertex1)) && Objects.nonNull(adjList.get(vertex2))) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertexToBeRemoved){
        if (Objects.nonNull(adjList.get(vertexToBeRemoved))) {
            adjList.get(vertexToBeRemoved).forEach(vertex -> adjList.get(vertex).remove(vertexToBeRemoved));
            adjList.remove(vertexToBeRemoved);
            return true;
        }
        return false;
    }

}
