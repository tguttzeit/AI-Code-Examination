package ChatGPT.FloydWarshall.AIGenerated.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Initialize the FloydWarshall objects for both graphs.
        floydWarshallGraph1 = new FloydWarshall(5);
        floydWarshallGraph2 = new FloydWarshall(5);

        // Build the first graph.
        floydWarshallGraph1.addEdge(0, 1, 10);
        floydWarshallGraph1.addEdge(0, 3, 5);
        floydWarshallGraph1.addEdge(1, 3, 2);
        floydWarshallGraph1.addEdge(1, 2, 1);
        floydWarshallGraph1.addEdge(2, 4, 4);
        floydWarshallGraph1.addEdge(3, 1, 3);
        floydWarshallGraph1.addEdge(3, 2, 9);
        floydWarshallGraph1.addEdge(3, 4, 2);
        floydWarshallGraph1.addEdge(4, 2, 6);

        // Build the second graph.
        floydWarshallGraph2.addEdge(0, 2, 5);
        floydWarshallGraph2.addEdge(1, 3, 5);
        floydWarshallGraph2.addEdge(2, 3, 4);
        floydWarshallGraph2.addEdge(3, 2, 4);
        floydWarshallGraph2.addEdge(4, 3, 4);
        floydWarshallGraph2.addEdge(2, 4, -2);

        // Run the algorithm for both graphs.
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path in graph 1 from node 0 to 4.
        assertEquals("[0, 3, 4]", floydWarshallGraph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path in graph 2 from node 0 to 4.
        assertEquals("[0, 2, 4]", floydWarshallGraph2.path(0, 4).toString());
    }

    @Test
    public void testShortestPathNoPath() {
        // Test a case with no path in graph 1 from node 4 to 0.
        assertEquals("[]", floydWarshallGraph1.path(4, 0).toString());
    }
}
