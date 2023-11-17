package ChatGPT.FloydWarshall.AIGenerated.T5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create instances of FloydWarshall for two different graphs.
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

        // Run Floyd-Warshall algorithm for both graphs
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test the shortest path from node 0 to node 4 in Graph 1
        // The shortest path is expected to be [0, 3, 4] with a total distance of 7.
        assertEquals(7, floydWarshallGraph1.distanceMatrix[0][4]);
        assertEquals("[0, 3, 4]", floydWarshallGraph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test the shortest path from node 1 to node 2 in Graph 2
        // The shortest path is expected to be [1, 3, 2] with a total distance of 9.
        assertEquals(9, floydWarshallGraph2.distanceMatrix[1][2]);
        assertEquals("[1, 3, 2]", floydWarshallGraph2.path(1, 2).toString());
    }

    @Test
    public void testNonexistentPath() {
        // Test a path that doesn't exist in Graph 1
        // The distance between node 2 and node 0 should be Integer.MAX_VALUE, indicating no path.
        assertEquals(Integer.MAX_VALUE, floydWarshallGraph1.distanceMatrix[2][0]);
        assertEquals("[]", floydWarshallGraph1.path(2, 0).toString());
    }
}
