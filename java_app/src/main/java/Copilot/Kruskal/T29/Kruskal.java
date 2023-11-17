package Copilot.Kruskal.T29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        int index = 0;
        while (result.size() < n - 1 && index < edges.size()) {
            Edge edge = edges.get(index);
            index++;
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                result.add(edge);
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
        public int[] father;
        public int[] size;

        public DisjointSet(int n) {
            father = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                father[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (size[rootX] < size[rootY]) {
                father[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                father[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

}
