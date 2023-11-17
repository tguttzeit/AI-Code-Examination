package Copilot.Kruskal.T44;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet set = new DisjointSet(n);
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        for(Edge edge : edges){
            int src = edge.src;
            int dest = edge.dest;
            if(set.find(src) != set.find(dest)){
                result.add(edge);
                set.union(src, dest);
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
                rank[i] = 0;
            }
        }
        public int find(int v){
            if(parent[v] != v){
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }
        public void union(int v1, int v2){
            int p1 = find(v1);
            int p2 = find(v2);
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }else{
                parent[p1] = p2;
                if(rank[p1] == rank[p2]){
                    rank[p2]++;
                }
            }
        }
    }

}
