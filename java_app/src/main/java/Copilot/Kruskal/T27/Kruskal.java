package Copilot.Kruskal.T27;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {  	public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
    DisjointSet set = new DisjointSet(n);
    List<Edge> mst = new ArrayList<>();
    Queue<Edge> pq = new PriorityQueue<>(edges);
    while(!pq.isEmpty()) {
        Edge edge = pq.poll();
        if(set.find(edge.src) != set.find(edge.dest)) {
            set.union(edge.src, edge.dest);
            mst.add(edge);
        }
    }
    return mst;
}
    public static class Edge implements Comparable<Edge> {
        public int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static class DisjointSet {
        private int[] parent;
        private int[] rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int i) {
            if(parent[i] == i)
                return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot == yRoot)
                return;
            if(rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if(rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

}
