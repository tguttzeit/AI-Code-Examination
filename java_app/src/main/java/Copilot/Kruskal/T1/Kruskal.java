package Copilot.Kruskal.T1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
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
        public int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static class DisjointSet{
        int[] parent, rank;
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py){
                return;
            }
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
