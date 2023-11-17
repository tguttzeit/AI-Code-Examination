package ChatGPT.BreadthFirstSearch.AIGenerated.T5;

import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testBFSWithSingleNodeGraph() {
        Graph breadthFirstSearch = new Graph(1);
        int[] parent = breadthFirstSearch.bfs(0);
        int[] expected = { -1 };
        assertArrayEquals(expected, parent);
    }

    @Test
    public void testBFSWithConnectedGraph() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(0);
        int[] expected = { -1, 0, 0, 1, 3, 3 };
        assertArrayEquals(expected, parent);
    }

    @Test
    public void testBFSWithUnconnectedGraph() {
        Graph breadthFirstSearch = new Graph(4);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(2, 3);

        int[] parent = breadthFirstSearch.bfs(0);
        int[] expected = { -1, 0, -1, -1 };
        assertArrayEquals(expected, parent);
    }
}
