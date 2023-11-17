package ChatGPT.FloydWarshall.BookExampleCode.T3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create instances of FloydWarshall for both graphs
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

        // Run the algorithm for both graphs
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1
        assertEquals("[0, 3, 4]", floydWarshallGraph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 0 to node 3 in Graph 2
        assertEquals("[0, 2, 3]", floydWarshallGraph2.path(0, 3).toString());
    }

    @Test
    public void testShortestPathGraph1Disconnected() {
        // Test a disconnected path in Graph 1 (should return an empty list)
        assertEquals("[]", floydWarshallGraph1.path(0, 5).toString());
    }
}
