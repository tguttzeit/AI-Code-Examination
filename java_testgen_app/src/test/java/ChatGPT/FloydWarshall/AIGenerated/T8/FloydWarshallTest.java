package ChatGPT.FloydWarshall.AIGenerated.T8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Initialize the graphs for testing.
        graph1 = new FloydWarshall(5);
        graph2 = new FloydWarshall(5);

        // Build the first graph (Graph 1).
        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 3, 5);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(2, 4, 4);
        graph1.addEdge(3, 1, 3);
        graph1.addEdge(3, 2, 9);
        graph1.addEdge(3, 4, 2);
        graph1.addEdge(4, 2, 6);

        // Build the second graph (Graph 2).
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(1, 3, 5);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 4);
        graph2.addEdge(4, 3, 4);
        graph2.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm on both graphs.
        graph1.run();
        graph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1.
        assertEquals("[0, 3, 4]", graph1.path(0, 4).toString());
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 0 to node 3 in Graph 2.
        assertEquals("[0, 2, 3]", graph2.path(0, 3).toString());
    }

    @Test
    public void testNonExistentPathGraph1() {
        // Test a path that does not exist in Graph 1.
        assertEquals("[]", graph1.path(4, 0).toString());
    }
}
