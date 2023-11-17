package Copilot.Kruskal.T50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        //initialize a list of edges
        List<Edge> result = new ArrayList<>();
        //sort the edges by weight
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        //initialize a DisjointSet object
        DisjointSet ds = new DisjointSet(n);
        //iterate the edges
        for (Edge edge : edges) {
            //if the src and dest nodes are not in the same set
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                //add the edge to the result
                result.add(edge);
                //union the src and dest nodes
                ds.union(edge.src, edge.dest);
            }
        }
        return result;
    }
    public static class Edge {
        public int src;
        public int dest;
        public int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static class DisjointSet {
        private int[] parents;
        private int[] ranks;
        public DisjointSet(int n) {
            parents = new int[n + 1];
            ranks = new int[n + 1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }
        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (ranks[px] > ranks[py]) {
                    parents[py] = px;
                } else if (ranks[px] < ranks[py]) {
                    parents[px] = py;
                } else {
                    parents[py] = px;
                    ranks[px]++;
                }
            }
        }
    }
}
