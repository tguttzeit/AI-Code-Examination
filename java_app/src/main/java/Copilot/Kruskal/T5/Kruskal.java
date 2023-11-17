package Copilot.Kruskal.T5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet set = new DisjointSet(n);
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        for(Edge edge: edges){
            if(set.union(edge.src, edge.dest)){
                result.add(edge);
            }
        }
        return result;
    }
    public static class Edge implements Comparable<Edge>{
        public int src;
        public int dest;
        public int weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }
    public static class DisjointSet{
        private int[] parent;
        private int[] rank;
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot == yRoot){
                return false;
            }
            if(rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
            }else if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            }else{
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
            return true;
        }
    }
}
