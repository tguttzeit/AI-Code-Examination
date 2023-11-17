package ChatGPT.FloydWarshall.AIGenerated.T4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FloydWarshallTest {

    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create graphs with the specified edges and weights.
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

        // Run the Floyd-Warshall algorithm.
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test the shortest path from node 0 to node 4 in graph 1.
        // Expected path: 0 -> 3 -> 4
        // Expected distance: 7
        assertEquals(7, floydWarshallGraph1.distanceMatrix[0][4]);
        assertEquals("[0, 3, 4]", floydWarshallGraph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test the shortest path from node 0 to node 3 in graph 2.
        // Expected path: 0 -> 2 -> 3
        // Expected distance: 9
        assertEquals(9, floydWarshallGraph2.distanceMatrix[0][3]);
        assertEquals("[0, 2, 3]", floydWarshallGraph2.path(0, 3).toString());
    }

    @Test
    public void testNoPath() {
        // Test a path that does not exist in graph 1.
        // There should be no path from node 4 to node 0.
        // Expected distance: Integer.MAX_VALUE
        assertEquals(Integer.MAX_VALUE, floydWarshallGraph1.distanceMatrix[4][0]);
        assertTrue(floydWarshallGraph1.path(4, 0).isEmpty());
    }
}
