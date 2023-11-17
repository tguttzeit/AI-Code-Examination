package Copilot.Kruskal.T19;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet disjointSet = new DisjointSet(n);
        List<Edge> result = new ArrayList<>();
        int index = 0;
        while (index < n - 1){
            Edge edge = edges.get(index);
            int src = edge.src;
            int dest = edge.dest;
            if (disjointSet.find(src) != disjointSet.find(dest)){
                result.add(edge);
                disjointSet.union(src, dest);
                index++;
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
        public DisjointSet(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                parent[rootX] = rootY;
            }
        }
    }
}
