package ChatGPT.DepthFirstSearch.BookExampleCode.T10;

// Source: https://www.techiedelight.com/depth-first-search/
/* CHANGES FOR EXPERIMENT:
   - made Edge to an inner class in the BookExample
   - created global variable visitedNodes (saves the Nodes in the order in
     which the algorithm is running through)
   - changed 'DFS' method name to 'dfs'
   - set comment signs to System.out.print() in dfs(method)
   - removed parameter 'DepthFirstSearch graph' in dfs method, because
     otherwise the method would demand its calling object to itself */

import java.util.ArrayList;
import java.util.List;

// A class to represent a graph object
public class DepthFirstSearch {
    // A list of lists to represent an adjacency list
    public List<List<Integer>> adjList;
    public ArrayList<Integer> visitedNodes = new ArrayList<>();

    // Constructor
    public DepthFirstSearch(List<Edge> edges, int n) {

        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }

    // Function to perform DFS traversal on the graph on a graph
    public void dfs(int v, boolean[] discovered) {
        // mark the current node as discovered
        discovered[v] = true;

        visitedNodes.add(v);

        // do for every edge (v, u)
        for (int u : adjList.get(v)) {
            // if `u` is not yet discovered
            if (!discovered[u]) {
                dfs(u, discovered);
            }
        }
    }

    public static class Edge {
        int source, dest;

        // A class to store a graph edge
        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}
