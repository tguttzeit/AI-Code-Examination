package ChatGPT.FloydWarshall.AIGenerated.T10;

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
        // Initialize the graphs with the given edges and weights.
        floydWarshallGraph1 = new FloydWarshall(5);
        floydWarshallGraph1.addEdge(0, 1, 10);
        floydWarshallGraph1.addEdge(0, 3, 5);
        floydWarshallGraph1.addEdge(1, 3, 2);
        floydWarshallGraph1.addEdge(1, 2, 1);
        floydWarshallGraph1.addEdge(2, 4, 4);
        floydWarshallGraph1.addEdge(3, 1, 3);
        floydWarshallGraph1.addEdge(3, 2, 9);
        floydWarshallGraph1.addEdge(3, 4, 2);
        floydWarshallGraph1.addEdge(4, 2, 6);

        floydWarshallGraph2 = new FloydWarshall(5);
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
        List<Integer> shortestPath = floydWarshallGraph1.path(0, 4);
        // Expected shortest path: [0, 3, 4]
        assertEquals(3, shortestPath.size());
        assertEquals(Integer.valueOf(0), shortestPath.get(0));
        assertEquals(Integer.valueOf(3), shortestPath.get(1));
        assertEquals(Integer.valueOf(4), shortestPath.get(2));
    }

    @Test
    public void testShortestPathGraph2() {
        List<Integer> shortestPath = floydWarshallGraph2.path(0, 3);
        // Expected shortest path: [0, 2, 3]
        assertEquals(3, shortestPath.size());
        assertEquals(Integer.valueOf(0), shortestPath.get(0));
        assertEquals(Integer.valueOf(2), shortestPath.get(1));
        assertEquals(Integer.valueOf(3), shortestPath.get(2));
    }

    @Test
    public void testNoPathGraph1() {
        List<Integer> shortestPath = floydWarshallGraph1.path(4, 0);
        // Expected result: No path exists, so the list should be empty.
        assertTrue(shortestPath.isEmpty());
    }
}
