package ChatGPT.FloydWarshall.PromptOnly.T5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {

    private FloydWarshall floydWarshall;

    @Before
    public void setUp() {
        // Initialize the FloydWarshall object for each test case
        floydWarshall = new FloydWarshall(5); // Assuming the graph has 5 nodes
    }

    @Test
    public void testGraph1ShortestPath() {
        // Build Graph 1
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 9);
        floydWarshall.addEdge(3, 4, 2);
        floydWarshall.addEdge(4, 2, 6);

        // Run the Floyd-Warshall algorithm
        floydWarshall.run();

        // Test shortest path from node 0 to node 4
        List<Integer> path = floydWarshall.path(0, 4);

        // Assert that the path is as expected
        assertEquals(List.of(0, 3, 4), path);
    }

    @Test
    public void testGraph2ShortestPath() {
        // Build Graph 2
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm
        floydWarshall.run();

        // Test shortest path from node 0 to node 3
        List<Integer> path = floydWarshall.path(0, 3);

        // Assert that the path is as expected
        assertEquals(List.of(0, 2, 3), path);
    }

    @Test
    public void testNoPathExists() {
        // Build a graph with no path from node 0 to node 1
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);

        // Run the Floyd-Warshall algorithm
        floydWarshall.run();

        // Test that there is no path from node 0 to node 1
        List<Integer> path = floydWarshall.path(0, 1);

        // Assert that the path is null (no path exists)
        assertNull(path);
    }
}
