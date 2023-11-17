package ChatGPT.BreadthFirstSearch.AIGenerated.T9;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        // Build a graph with the specified edges
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromNode0() {
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] resultParent = graph.bfs(0);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] expectedParent = {1, -1, 0, -1, -1, -1};
        int[] resultParent = graph.bfs(1);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode4() {
        int[] expectedParent = {-1, -1, -1, 3, -1, -1};
        int[] resultParent = graph.bfs(4);
        assertArrayEquals(expectedParent, resultParent);
    }
}
