package Copilot.Kruskal.T28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        //Create the DisjointSet
        DisjointSet graph = new DisjointSet(n);
        //Create the List to return
        List<Edge> returnList = new ArrayList<>();
        //Sort the edges
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        //Loop through the edges
        for (Edge e : edges) {
            //Check if the edge creates a cycle
            if (graph.find(e.src) != graph.find(e.dest)) {
                //Add the edge to the return list
                returnList.add(e);
                //Merge the sets
                graph.union(e.src, e.dest);
            }
        }
        //Return the list
        return returnList;
    }
    public static class Edge {
        public int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static class DisjointSet {
        private int[] parent, size;
        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }
            if (size[xRoot] < size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            } else {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            }
        }
    }
}
