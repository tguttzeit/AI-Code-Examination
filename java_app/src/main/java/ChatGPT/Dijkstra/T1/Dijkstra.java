package ChatGPT.Dijkstra.T1;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[source] = 0;
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            if (currentNode.weight > distances[currentVertex]) {
                continue;
            }

            shortestPaths.put(currentVertex, distances[currentVertex]);

            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int weight = edge.weight;

                    if (distances[currentVertex] != Integer.MAX_VALUE
                            && distances[currentVertex] + weight < distances[neighbor]) {
                        distances[neighbor] = distances[currentVertex] + weight;
                        minHeap.offer(new Node(neighbor, distances[neighbor]));
                    }
                }
            }
        }

        return shortestPaths;
    }

    public static class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}
