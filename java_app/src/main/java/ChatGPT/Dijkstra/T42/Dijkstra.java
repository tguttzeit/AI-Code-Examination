package ChatGPT.Dijkstra.T42;

import java.util.*;

public class Dijkstra {
    private Map<Integer, List<Edge>> graph;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.n = n;
        this.graph = new HashMap<>();

        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new ArrayList<>());
            graph.get(edge.source).add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Set<Integer> visited = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }

        shortestPaths.put(source, 0);
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            if (graph.containsKey(currentVertex)) {
                for (Edge neighborEdge : graph.get(currentVertex)) {
                    int neighbor = neighborEdge.dest;
                    int weight = neighborEdge.weight;

                    if (!visited.contains(neighbor) && shortestPaths.get(currentVertex) != Integer.MAX_VALUE
                            && shortestPaths.get(currentVertex) + weight < shortestPaths.get(neighbor)) {
                        shortestPaths.put(neighbor, shortestPaths.get(currentVertex) + weight);
                        minHeap.offer(new Node(neighbor, shortestPaths.get(neighbor)));
                    }
                }
            }
        }

        shortestPaths.remove(source); // Remove source vertex from the result map
        shortestPaths.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE); // Remove unreachable nodes

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
