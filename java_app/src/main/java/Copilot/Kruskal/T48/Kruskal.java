package Copilot.Kruskal.T48;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet disjointSet = new DisjointSet(n);
        edges.sort((e1, e2) -> e1.weight - e2.weight);
        List<Edge> result = new ArrayList<>();
        for(Edge edge : edges){
            if(disjointSet.union(edge.src, edge.dest)){
                result.add(edge);
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
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }
}
