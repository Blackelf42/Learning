import java.util.*;

public class Dijkstra {

    public static double[] dijkstra(Graph graph, int source) {
        int verticeCount = graph.getVertices();
        double[] distances = new double[verticeCount];
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        distances[source] = 0;

        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        FibonacciHeap.Entry<Integer>[] entries = new FibonacciHeap.Entry[verticeCount];

        for (int i = 0; i < verticeCount; i++) {
            entries[i] = heap.enqueue(i, distances[i]);
        }

        while (!heap.isEmpty()) {
            FibonacciHeap.Entry<Integer> currentEntry = heap.dequeueMin();
            int u = currentEntry.getValue();

            for (Edge edge : graph.getEdges(u)) {
                int v = edge.getTarget();
                double newDist = distances[u] + edge.getWeight();

                if (newDist < distances[v]) {
                    distances[v] = newDist;
                    heap.decreaseKey(entries[v], newDist);
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        double[] distances = dijkstra(graph, 0);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);
        }
    }
}
