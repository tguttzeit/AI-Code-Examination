package Copilot.Kruskal.T21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    static class Edge{
        public int src;
        public int dest;
        public int weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class DisjointSet{
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
        public int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public void union(int x, int y){
            int xroot = find(x);
            int yroot = find(y);
            if(rank[xroot] < rank[yroot]){
                parent[xroot] = yroot;
            }else if(rank[xroot] > rank[yroot]){
                parent[yroot] = xroot;
            }else{
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        DisjointSet ds = new DisjointSet(n);
        for(Edge e : edges){
            int x = ds.find(e.src);
            int y = ds.find(e.dest);
            if(x != y){
                mst.add(e);
                ds.union(x, y);
            }
        }
        return mst;
    }

}
