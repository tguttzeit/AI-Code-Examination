package ChatGPT.FloydWarshall.AIGenerated.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FloydWarshallTest {
    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Create instances of FloydWarshall for each graph.
        graph1 = new FloydWarshall(5);
        graph2 = new FloydWarshall(5);

        // Build Graph 1
        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 3, 5);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(2, 4, 4);
        graph1.addEdge(3, 1, 3);
        graph1.addEdge(3, 2, 9);
        graph1.addEdge(3, 4, 2);
        graph1.addEdge(4, 2, 6);

        // Build Graph 2
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(1, 3, 5);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 4);
        graph2.addEdge(4, 3, 4);
        graph2.addEdge(2, 4, -2);

        // Run Floyd-Warshall algorithm on both graphs.
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
        // Test shortest path from node 0 to node 4 in Graph 2.
        assertEquals("[0, 2, 4]", graph2.path(0, 4).toString());
    }

    @Test
    public void testNoPathGraph1() {
        // Test a path that does not exist in Graph 1 (e.g., node 0 to node 5).
        assertEquals("[]", graph1.path(0, 5).toString());
    }
}
