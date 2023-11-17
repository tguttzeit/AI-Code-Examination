package Copilot.Kruskal.T49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List runKruskalAlgorithm(List<Edge> edges, int n){
        List mst = new ArrayList();
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges);
        for(Edge e : edges){
            int u = e.src;
            int v = e.dest;
            if(ds.find(u) != ds.find(v)){
                mst.add(e);
                ds.union(u,v);
            }
        }
        return mst;
    }
    public static class Edge implements Comparable<Edge>{
        public int src;
        public int dest;
        public int weight;
        public Edge(int u, int v, int w){
            src = u;
            dest = v;
            weight = w;
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
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int u){
            if(parent[u] == u){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv){
                return;
            }
            if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }
            else if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }
            else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
}
