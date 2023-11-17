package Copilot.Kruskal.T4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet set = new DisjointSet(n);
        for(Edge e: edges){
            if(set.find(e.src) != set.find(e.dest)){
                mst.add(e);
                set.union(e.src, e.dest);
            }
        }
        return mst;
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
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if(rank[rootY] < rank[rootX]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
