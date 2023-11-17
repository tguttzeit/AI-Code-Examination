package ChatGPT.BreadthFirstSearch.AIGenerated.T4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

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
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] result = graph.bfs(0);
        assertArrayEquals(expectedParent, result);
    }

    @Test
    public void testBFSStartingFromVertex2() {
        int[] expectedParent = {-1, -1, 2, 2, 3, 3};
        int[] result = graph.bfs(2);
        assertArrayEquals(expectedParent, result);
    }

    @Test
    public void testBFSStartingFromVertex4() {
        int[] expectedParent = {-1, -1, -1, -1, 3, 3};
        int[] result = graph.bfs(4);
        assertArrayEquals(expectedParent, result);
    }
}
