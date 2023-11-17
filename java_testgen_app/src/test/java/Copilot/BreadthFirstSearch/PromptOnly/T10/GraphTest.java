package Copilot.BreadthFirstSearch.PromptOnly.T10;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    @Test
    public void testBFS() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        int[] bfs = graph.bfs(0);
        assertArrayEquals(new int[] { -1, 0, 0, 1, 3, 3 }, bfs);
    }

}