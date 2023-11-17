package ChatGPT.FloydWarshall.PromptOnly.T8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {
    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Create instances of the FloydWarshall class for two graphs
        graph1 = new FloydWarshall(5);
        graph2 = new FloydWarshall(5);

        // Add edges and weights for graph 1
        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 3, 5);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(2, 4, 4);
        graph1.addEdge(3, 1, 3);
        graph1.addEdge(3, 2, 9);
        graph1.addEdge(3, 4, 2);
        graph1.addEdge(4, 2, 6);

        // Add edges and weights for graph 2
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(1, 3, 5);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 4);
        graph2.addEdge(4, 3, 4);
        graph2.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm for both graphs
        graph1.run();
        graph2.run();
    }

    @Test
    public void testPathGraph1() {
        // Test path from node 0 to node 4 in graph 1
        List<Integer> path = graph1.path(0, 4);
        assertEquals(3, path.size()); // Expected path length: 3
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(4), path.get(2));
    }

    @Test
    public void testPathGraph2() {
        // Test path from node 1 to node 2 in graph 2
        List<Integer> path = graph2.path(1, 2);
        assertEquals(2, path.size()); // Expected path length: 2
        assertEquals(Integer.valueOf(1), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
    }

    @Test
    public void testPathSameNode() {
        // Test path from node 2 to itself in graph 1 (should return an empty list)
        List<Integer> path = graph1.path(2, 2);
        assertTrue(path.isEmpty());
    }
}
