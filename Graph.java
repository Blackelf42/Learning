import java.util.*;

public class Graph {
    List<List<Edge>> adjList;

    public List<Edge> getEdges(int vertex) {
        return adjList.get(vertex);
    }

    public int getVerticeCount() {
        return adjList.size();
    }

    Graph(int verticeCount) {
        adjList = new ArrayList<>(verticeCount);
        for (int i = 0; i < verticeCount; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int target, double weight) {
        adjList.get(source).add(new Edge(target, weight));
    }
}