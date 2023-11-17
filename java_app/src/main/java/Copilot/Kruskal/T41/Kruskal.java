package Copilot.Kruskal.T41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet set = new DisjointSet(n);
        List<Edge> result = new ArrayList<Edge>();
        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        for(Edge e : edges){
            int src = e.src;
            int dest = e.dest;
            if(set.find(src) != set.find(dest)){
                set.union(src, dest);
                result.add(e);
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
        private int[] parent;
        private int[] rank;
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
                return find(parent[x]);
            }
            return x;
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
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }

}
