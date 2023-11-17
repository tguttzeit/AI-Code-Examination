package ChatGPT.BreadthFirstSearch.AIGenerated.T8;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        // Build the graph with the specified edges
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    @Test
    public void testBfsStartingFromVertex0() {
        int[] expectedParent = { -1, 0, 0, 1, 3, 3 };
        int[] actualParent = graph.bfs(0);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBfsStartingFromVertex1() {
        int[] expectedParent = { 1, -1, 0, 1, 3, 3 };
        int[] actualParent = graph.bfs(1);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBfsStartingFromVertex3() {
        int[] expectedParent = { 3, 0, 0, -1, 3, 3 };
        int[] actualParent = graph.bfs(3);
        assertArrayEquals(expectedParent, actualParent);
    }
}
