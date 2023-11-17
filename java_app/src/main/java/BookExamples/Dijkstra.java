package BookExamples;
// Source: https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm/
/* CHANGES FOR EXPERIMENT:
   - renamed Graph class into Dijkstra
   - made Edge & Node to inner classes of the Dijkstra
   - added Map<Integer, Map<Integer,List<List<Integer>>>> overview;
    Map<Integer,List<List<Integer>>> innerMap; for test purposes
   - made print statements to comments
   - added onlyPositiveEdgeCosts() method, because this check is significant for the dijkstra algorithm */

import java.util.*;

// A class to represent a graph object
public class Dijkstra {
    // A list of lists to represent an adjacency list
    List<List<Edge>> adjList;
    int n;

    // Constructor
    Dijkstra(List<Edge> edges, int n) {

        adjList = new ArrayList<>();
        this.n = n;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }

    // CHANGES FOR EXPERIMENT: Manually added method, because this is a significant property of the dijkstra algorithm
    public boolean onlyPositiveEdgeCosts() {
        int i;
        int j;
        for (i = 0; i < adjList.size(); i++) {
            for (j = 0; j < adjList.get(i).size(); j++) {
                if (adjList.get(i).get(j).weight < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    // Run Dijkstra’s algorithm on a given graph
    // CHANGES FOR EXPERIMENT: Changed return type to return the destination node and its distance.
    public  Map<Integer, Integer> findShortestPaths(int source) {

        //CHANGES FOR EXPERIMENT: Manually added if-statement
        if (onlyPositiveEdgeCosts()) {

            // create a min-heap and push source node having distance 0
            PriorityQueue<Node> minHeap;
            minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            minHeap.add(new Node(source, 0));

            // set initial distance from the source to `v` as infinity
            List<Integer> dist;
            dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

            // distance from the source to itself is zero
            dist.set(source, 0);

            // boolean array to track vertices for which minimum
            // cost is already found
            boolean[] done = new boolean[n];
            done[source] = true;

            // run till min-heap is empty
            while (!minHeap.isEmpty()) {
                // Remove and return the best vertex
                Node node = minHeap.poll();

                // get the vertex number
                int u = node.vertex;

                // do for each neighbor `v` of `u`
                for (Edge edge : adjList.get(u)) {
                    int v = edge.dest;
                    int weight = edge.weight;

                    // Relaxation step
                    if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                        dist.set(v, dist.get(u) + weight);
                        minHeap.add(new Node(v, dist.get(v)));
                    }
                }

                // mark vertex `u` as done so it will not get picked up again
                done[u] = true;
            }

            // CHANGES FOR EXPERIMENT: Path map returns the destination node and the distance to it.
            Map<Integer, Integer> pathMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                    pathMap.put(i, dist.get(i));
                }
            }
            return pathMap;
        }
        return null;
    }

    // A class to store a graph edge
    public static class Edge {
        int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // A class to store a heap node
    public class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}