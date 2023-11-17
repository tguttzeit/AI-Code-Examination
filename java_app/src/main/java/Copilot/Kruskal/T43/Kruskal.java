package Copilot.Kruskal.T43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static class Edge{
        public int src;
        public int dest;
        public int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges, (a, b)->a.weight-b.weight);
        for(Edge e: edges) {
            if(ds.find(e.src)!=ds.find(e.dest)) {
                ds.union(e.src, e.dest);
                mst.add(e);
            }
        }
        return mst;
    }
    public static class DisjointSet{
        int[] parent;
        int[] rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if(parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot==yRoot) return;
            if(rank[xRoot]<rank[yRoot]) {
                parent[xRoot] = yRoot;
            }else if(rank[xRoot]>rank[yRoot]) {
                parent[yRoot] = xRoot;
            }else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }
}
