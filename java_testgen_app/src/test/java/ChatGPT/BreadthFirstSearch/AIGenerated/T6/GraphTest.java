package ChatGPT.BreadthFirstSearch.AIGenerated.T6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        // Create a new graph with 6 vertices
        graph = new Graph(6);

        // Build the graph with the given edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromVertex0() {
        int[] parent = graph.bfs(0);

        // Verify the parent array for BFS starting from vertex 0
        assertArrayEquals(new int[]{-1, 0, 0, 1, -1, -1}, parent);
    }

    @Test
    public void testBFSStartingFromVertex1() {
        int[] parent = graph.bfs(1);

        // Verify the parent array for BFS starting from vertex 1
        assertArrayEquals(new int[]{1, -1, -1, 0, -1, -1}, parent);
    }

    @Test
    public void testBFSStartingFromVertex3() {
        int[] parent = graph.bfs(3);

        // Verify the parent array for BFS starting from vertex 3
        assertArrayEquals(new int[]{1, 2, 3, -1, 3, 3}, parent);
    }
}
