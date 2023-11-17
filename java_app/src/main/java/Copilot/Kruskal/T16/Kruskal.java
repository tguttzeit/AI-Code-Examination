package Copilot.Kruskal.T16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge x, Edge y){
                return x.weight - y.weight;
            }
        });
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
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py){
                return;
            }
            if(rank[px] > rank[py]){
                parent[py] = px;
                rank[px] += rank[py];
            }else{
                parent[px] = py;
                rank[py] += rank[px];
            }
        }
    }
}
