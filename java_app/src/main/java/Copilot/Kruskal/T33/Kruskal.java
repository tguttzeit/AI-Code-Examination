package Copilot.Kruskal.T33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(n);
        for(Edge edge : edges){
            if(ds.find(edge.src) != ds.find(edge.dest)){
                result.add(edge);
                ds.union(edge.src, edge.dest);
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

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
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
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

}
