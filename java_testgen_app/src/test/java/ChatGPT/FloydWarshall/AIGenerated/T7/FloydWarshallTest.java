package ChatGPT.FloydWarshall.AIGenerated.T7;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create two instances of the FloydWarshall class for testing.
        floydWarshallGraph1 = new FloydWarshall(5);
        floydWarshallGraph2 = new FloydWarshall(5);

        // Build Graph 1
        floydWarshallGraph1.addEdge(0, 1, 10);
        floydWarshallGraph1.addEdge(0, 3, 5);
        floydWarshallGraph1.addEdge(1, 3, 2);
        floydWarshallGraph1.addEdge(1, 2, 1);
        floydWarshallGraph1.addEdge(2, 4, 4);
        floydWarshallGraph1.addEdge(3, 1, 3);
        floydWarshallGraph1.addEdge(3, 2, 9);
        floydWarshallGraph1.addEdge(3, 4, 2);
        floydWarshallGraph1.addEdge(4, 2, 6);

        // Build Graph 2
        floydWarshallGraph2.addEdge(0, 2, 5);
        floydWarshallGraph2.addEdge(1, 3, 5);
        floydWarshallGraph2.addEdge(2, 3, 4);
        floydWarshallGraph2.addEdge(3, 2, 4);
        floydWarshallGraph2.addEdge(4, 3, 4);
        floydWarshallGraph2.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm for both graphs.
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1.
        List<Integer> shortestPath = floydWarshallGraph1.path(0, 4);
        assertEquals(3, shortestPath.size());
        assertEquals(0, (int) shortestPath.get(0));
        assertEquals(3, (int) shortestPath.get(1));
        assertEquals(4, (int) shortestPath.get(2));
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 1 to node 2 in Graph 2.
        List<Integer> shortestPath = floydWarshallGraph2.path(1, 2);
        assertEquals(3, shortestPath.size());
        assertEquals(1, (int) shortestPath.get(0));
        assertEquals(3, (int) shortestPath.get(1));
        assertEquals(2, (int) shortestPath.get(2));
    }

    @Test
    public void testNoPathGraph1() {
        // Test a scenario where there is no path from node 4 to node 0 in Graph 1.
        List<Integer> shortestPath = floydWarshallGraph1.path(4, 0);
        assertTrue(shortestPath.isEmpty());
    }
}
