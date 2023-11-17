package Copilot.BreadthFirstSearch.BookExampleCode.T4;

public class GraphTest {
    public static void main(String[] args) {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        int[] parent = breadthFirstSearch.bfs(0);
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + " " + parent[i]);
        }
    }


}