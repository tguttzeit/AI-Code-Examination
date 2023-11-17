package ChatGPT.BellmanFord.BookExampleCode.T10;

// Source: https://www.techiedelight.com/single-source-shortest-paths-bellman-ford-algorithm/
// CHANGE FOR EXPERIMENT: Book example got modified to fit the test class.
// CHANGE FOR EXPERIMENT: getPath() method got removed, as we are only interested in the distance.

import java.util.*;

// A class to store a graph edge
class BellmanFord
{

    // Function to run the Bellman–Ford algorithm from a given source
    // CHANGE FOR EXPERIMENT: Added return type Map<Integer, Integer> to return the distance map.
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n)
    {
        // distance[] and parent[] stores the shortest path
        // (least cost/path) information
        int[] distance = new int[n];

        // initialize `distance[]` and `parent[]`. Initially, all vertices
        // except source vertex weight INFINITY and no parent
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // relaxation step (run V-1 times)
        for (int i = 0; i < n - 1; i++)
        {
            for (Edge edge: edges)
            {
                // edge from `u` to `v` having weight `w`
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;

                // if the distance to destination `v` can be
                // shortened by taking edge (u, v)
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
                {
                    // update distance to the new lower value
                    distance[v] = distance[u] + w;
                }
            }
        }

        // run relaxation step once more for n'th time to
        // check for negative-weight cycles
        for (Edge edge: edges)
        {
            // edge from `u` to `v` having weight `w`
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;

            // if the distance to destination `u` can be
            // shortened by taking edge (u, v)
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
            {
                // negative-weight cycle is found
                return null;
            }
        }
        // CHANGE FOR EXPERIMENT: Path map returns the destination node and the distance to it.
        Map<Integer, Integer> pathMap = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (i != source && distance[i] < Integer.MAX_VALUE) {
                pathMap.put(i, distance[i]);
            }
        }
        return pathMap;
    }

    public static class Edge
    {
        public int source, dest, weight;

        public Edge(int source, int dest, int weight)
        {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
}