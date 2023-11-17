package Copilot.Kruskal.T46;

import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        //implement
        return null;
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
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 0;
            }
        }

        public int find(int x){
            if(this.parent[x] != x){
                this.parent[x] = this.find(this.parent[x]);
            }
            return this.parent[x];
        }

        public void union(int x, int y) {
            int xRoot = this.find(x);
            int yRoot = this.find(y);
            if (xRoot == yRoot) {
                return;
            }
            if (this.rank[xRoot] < this.rank[yRoot]) {
                this.parent[xRoot] = yRoot;

            }
        }
    }
}