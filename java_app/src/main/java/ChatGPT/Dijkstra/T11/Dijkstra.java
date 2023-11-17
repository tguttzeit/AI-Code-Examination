package ChatGPT.Dijkstra.T11;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize distance and visited arrays
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Create a priority queue for min-heap
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            // If the node is already visited, skip it
            if (visited[u]) continue;

            visited[u] = true;

            for (Edge edge : edges) {
                if (edge.source == u) {
                    int v = edge.dest;
                    int weight = edge.weight;

                    // Relaxation step
                    if (!visited[v] && distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                        pq.add(new Node(v, distance[v]));
                    }
                }
            }
        }

        // Create a map to store the shortest distances
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != source && distance[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distance[i]);
            }
        }

        return shortestPaths;
    }

    public static class Edge {
        public int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Node {
        public int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
