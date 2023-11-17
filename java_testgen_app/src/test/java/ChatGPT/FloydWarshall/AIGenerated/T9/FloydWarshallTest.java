package ChatGPT.FloydWarshall.AIGenerated.T9;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private FloydWarshall floydWarshall;

    @Before
    public void setUp() {
        // Initialize a new FloydWarshall instance for each test.
        floydWarshall = new FloydWarshall(5); // Assuming 5 nodes in the graph.
    }

    @Test
    public void testShortestPathGraph1() {
        // Build the graph for Graph 1.
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 9);
        floydWarshall.addEdge(3, 4, 2);
        floydWarshall.addEdge(4, 2, 6);

        // Run the Floyd-Warshall algorithm.
        floydWarshall.run();

        // Test shortest path from node 0 to node 4.
        List<Integer> shortestPath = floydWarshall.path(0, 4);
        assertEquals(3, shortestPath.size());
        assertEquals(0, shortestPath.get(0).intValue());
        assertEquals(3, shortestPath.get(1).intValue());
        assertEquals(4, shortestPath.get(2).intValue());
    }

    @Test
    public void testShortestPathGraph2() {
        // Build the graph for Graph 2.
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm.
        floydWarshall.run();

        // Test shortest path from node 0 to node 3.
        List<Integer> shortestPath = floydWarshall.path(0, 3);
        assertEquals(3, shortestPath.size());
        assertEquals(0, shortestPath.get(0).intValue());
        assertEquals(2, shortestPath.get(1).intValue());
        assertEquals(3, shortestPath.get(2).intValue());
    }

    @Test
    public void testNoPath() {
        // Run the Floyd-Warshall algorithm without adding any edges.
        floydWarshall.run();

        // Test for a path that does not exist.
        List<Integer> shortestPath = floydWarshall.path(0, 4);
        assertEquals(0, shortestPath.size());
    }
}
