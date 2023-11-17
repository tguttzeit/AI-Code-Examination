package Copilot.BellmanFord.T5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static class Edge{
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight){
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n){
        Map<Integer, Integer> result = new HashMap<>();
        result.put(source, 0);
        for(int i = 1; i < n; i++){
            result.put(i, Integer.MAX_VALUE);
        }

        for(int i = 0; i < n - 1; i++){
            for(Edge edge: edges){
                if(result.get(edge.source) != Integer.MAX_VALUE && result.get(edge.source) + edge.weight < result.get(edge.dest)){
                    result.put(edge.dest, result.get(edge.source) + edge.weight);
                }
            }
        }

        for(Edge edge: edges){
            if(result.get(edge.source) != Integer.MAX_VALUE && result.get(edge.source) + edge.weight < result.get(edge.dest)){
                return null;
            }
        }

        return result;
    }
};