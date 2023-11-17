package Copilot.BreadthFirstSearch.PromptOnly.T7;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        int[] bfs = graph.bfs(0);
        for (int i = 0; i < bfs.length; i++) {
            System.out.println(bfs[i]);
        }
    }


}