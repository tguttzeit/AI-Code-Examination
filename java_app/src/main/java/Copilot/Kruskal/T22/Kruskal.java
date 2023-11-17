package Copilot.Kruskal.T22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, (a, b) -> a.weight - b.weight);
        DisjointSet ds = new DisjointSet(n);
        for(Edge edge : edges){
            if(ds.find(edge.src) != ds.find(edge.dest)){
                result.add(edge);
                ds.union(edge.src, edge.dest);
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
        public int[] parent;
        public int[] rank;
        public DisjointSet(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot == yRoot){
                return;
            }
            if(rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
            }
            else if(rank[yRoot] < rank[xRoot]){
                parent[yRoot] = xRoot;
            }
            else{
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

}
