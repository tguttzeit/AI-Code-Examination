package Copilot.Kruskal.T31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        DisjointSet ds = new DisjointSet(n);
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
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            if(rank[px] > rank[py]){
                parent[py] = px;
            }
            else if(rank[px] < rank[py]){
                parent[px] = py;
            }
            else{
                parent[px] = py;
                rank[py]++;
            }
        }
    }
}
