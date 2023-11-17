package Copilot.Kruskal.T34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(n);
        for(Edge edge: edges){
            int src = edge.src;
            int dest = edge.dest;
            if(ds.find(src) != ds.find(dest)){
                ds.union(src, dest);
                result.add(edge);
            }
        }
        return result;
    }
    public static class Edge implements Comparable<Edge>{
        public int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge other){
            return this.weight - other.weight;
        }
    }
    public static class DisjointSet{
        public int[] parent, rank;
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
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
            }else if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            }else{
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }
}
