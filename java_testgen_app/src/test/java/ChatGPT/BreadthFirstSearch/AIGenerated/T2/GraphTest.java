package ChatGPT.BreadthFirstSearch.AIGenerated.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a new graph with 6 vertices
        breadthFirstSearch = new Graph(6);
        // Build the graph with the specified edges
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromVertex0() {
        int[] parent = breadthFirstSearch.bfs(0);

        // Check the parent array
        assertArrayEquals(new int[]{-1, 0, 0, 1, 3, 3}, parent);
    }

    @Test
    public void testBFSStartingFromVertex1() {
        int[] parent = breadthFirstSearch.bfs(1);

        // Check the parent array
        assertArrayEquals(new int[]{-1, -1, 1, 0, 3, 3}, parent);
    }

    @Test
    public void testBFSStartingFromVertex3() {
        int[] parent = breadthFirstSearch.bfs(3);

        // Check the parent array
        assertArrayEquals(new int[]{-1, -1, 3, 1, -1, -1}, parent);
    }
}
