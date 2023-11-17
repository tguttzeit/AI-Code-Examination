package Copilot.Kruskal.T24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<Edge>();
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(n);
        for(Edge e: edges){
            if(ds.find(e.src) != ds.find(e.dest)){
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return mst;
    }

    public static class Edge implements Comparable<Edge>{
        public int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return weight - e.weight;
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

        public int find(int i){
            if(parent[i] == i){
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j){
            int root1 = find(i);
            int root2 = find(j);
            if(root1 == root2){
                return;
            }
            if(rank[root1] > rank[root2]){
                parent[root2] = root1;
            }
            else if(rank[root1] < rank[root2]){
                parent[root1] = root2;
            }
            else{
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }

}
