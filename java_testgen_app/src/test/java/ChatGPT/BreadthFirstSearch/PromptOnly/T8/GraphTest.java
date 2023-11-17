package ChatGPT.BreadthFirstSearch.PromptOnly.T8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        // Create a new graph with 6 vertices
        graph = new Graph(6);
        // Build the graph with the specified edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromVertex0() {
        int[] result = graph.bfs(0);

        // Check that the parent node of vertex 0 is -1
        assertEquals(-1, result[0]);

        // Check other parent nodes
        assertEquals(0, result[1]);
        assertEquals(0, result[2]);
        assertEquals(1, result[3]);
        assertEquals(3, result[4]);
        assertEquals(3, result[5]);
    }

    @Test
    public void testBFSStartingFromVertex3() {
        int[] result = graph.bfs(3);

        // Check that the parent node of vertex 3 is -1
        assertEquals(-1, result[3]);

        // Check other parent nodes
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[4]);
        assertEquals(3, result[5]);
    }

    @Test
    public void testAddEdge() {
        // Add a new edge
        graph.addEdge(4, 5);
        int[] result = graph.bfs(0);

        // Check that the parent node of vertex 5 is now 4
        assertEquals(4, result[5]);
    }
}
