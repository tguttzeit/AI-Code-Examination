package ChatGPT.FloydWarshall.BookExampleCode.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create graphs and add edges for Graph 1 and Graph 2
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

        // Run the algorithm on both graphs
        floydWarshallGraph1.run();
        floydWarshallGraph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test the shortest path from node 0 to node 4 in Graph 1
        assertEquals("[0, 3, 4]", floydWarshallGraph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test the shortest path from node 0 to node 3 in Graph 2
        assertEquals("[0, 2, 3]", floydWarshallGraph2.path(0, 3).toString());
    }

    @Test
    public void testNegativeWeightCycleGraph2() {
        // Test that Graph 2 has a negative weight cycle
        // In this case, it should return an empty list since there is no valid path
        assertEquals("[]", floydWarshallGraph2.path(4, 0).toString());
    }
}
