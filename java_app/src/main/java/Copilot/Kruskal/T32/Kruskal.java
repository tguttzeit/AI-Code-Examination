package Copilot.Kruskal.T32;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<Edge>();
        DisjointSet ds = new DisjointSet(n);
        for (Edge e : edges){
            if (ds.find(e.src) != ds.find(e.dest)){
                result.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return result;
    }

    public static class Edge{
        public int src;
        public int dest;
        public int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class DisjointSet{
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i){
            if (parent[i] == i){
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot){
                return;
            }
            if (rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }
}
