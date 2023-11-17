package Copilot.Kruskal.T3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        DisjointSet disjointSet = new DisjointSet(n);
        List<Edge> result = new ArrayList<Edge>();
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        for(Edge edge : edges){
            if(disjointSet.find(edge.src) != disjointSet.find(edge.dest)){
                disjointSet.union(edge.src, edge.dest);
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
        private int[] parents;
        public DisjointSet(int n){
            parents = new int[n];
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }
        }
        public int find(int x){
            if(parents[x] == x){
                return x;
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }
        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if(parentX != parentY){
                parents[parentX] = parentY;
            }
        }
    }
}
