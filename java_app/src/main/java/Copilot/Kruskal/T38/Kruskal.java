package Copilot.Kruskal.T38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet set = new DisjointSet(n);
        for(Edge edge: edges){
            if(set.find(edge.src) != set.find(edge.dest)){
                result.add(edge);
                set.union(edge.src, edge.dest);
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
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }
    public static class DisjointSet{
        int[] parent, rank;
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
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

}
