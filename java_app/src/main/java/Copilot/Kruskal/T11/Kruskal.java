package Copilot.Kruskal.T11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        //sort edges by weight
        Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);
        for(Edge e : edges){
            if(ds.find(e.src) != ds.find(e.dest)){
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return mst;
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
