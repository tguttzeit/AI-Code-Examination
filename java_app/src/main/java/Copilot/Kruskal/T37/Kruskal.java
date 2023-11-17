package Copilot.Kruskal.T37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);
        DisjointSet ds = new DisjointSet(n);
        for(Edge edge : edges){
            int src = edge.src;
            int dest = edge.dest;
            if(ds.find(src) != ds.find(dest)){
                result.add(edge);
                ds.union(src, dest);
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
        int[] parent;
        public DisjointSet(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return find(parent[x]);
        }
        public void union(int x, int y){
            int xParent = find(x);
            int yParent = find(y);
            if(xParent != yParent){
                parent[xParent] = yParent;
            }
        }
    }
}
