package Copilot.Kruskal.T20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet ds = new DisjointSet(n);
        List<Edge> ret = new ArrayList<Edge>();
        Collections.sort(edges);
        for (Edge e:edges){
            if (ds.find(e.src)!=ds.find(e.dest)){
                ret.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return ret;
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
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int i){
            if (parent[i] == i){
                return i;
            }
            else{
                parent[i] = find(parent[i]);
                return parent[i];
            }
        }
        public void union(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot){
                return;
            }
            if (rank[iRoot] < rank[jRoot]){
                parent[iRoot] = jRoot;
            }
            else if (rank[iRoot] > rank[jRoot]){
                parent[jRoot] = iRoot;
            }
            else{
                parent[iRoot] = jRoot;
                rank[jRoot]++;
            }
        }
    }

}
