package ChatGPT.FloydWarshall.AIGenerated.T6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create instances of FloydWarshall for Graph 1 and Graph 2
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

        // Run the algorithm on both graphs
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1
        int source = 0;
        int dest = 4;
        int[] expectedPath = {0, 3, 4};
        assertEquals(floydWarshallGraph1.path(source, dest), expectedPath);
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 1 to node 2 in Graph 2
        int source = 1;
        int dest = 2;
        int[] expectedPath = {1, 3, 2};
        assertEquals(floydWarshallGraph2.path(source, dest), expectedPath);
    }

    @Test
    public void testShortestPathNoPath() {
        // Test a case with no path from node 0 to node 1 in Graph 1
        int source = 0;
        int dest = 1;
        int[] expectedPath = {};
        assertEquals(floydWarshallGraph1.path(source, dest), expectedPath);
    }
}
