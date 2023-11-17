package ChatGPT.FloydWarshall.AIGenerated.T3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FloydWarshallTest {
    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Create the Floyd-Warshall objects for Graph 1 and Graph 2.
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

        // Run the Floyd-Warshall algorithm for both graphs.
        graph1.run();
        graph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1.
        List<Integer> shortestPath = graph1.path(0, 4);
        assertEquals(List.of(0, 3, 4), shortestPath);
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 1 to node 4 in Graph 2.
        List<Integer> shortestPath = graph2.path(1, 4);
        assertEquals(List.of(1, 3, 2, 4), shortestPath);
    }

    @Test
    public void testNoPathGraph1() {
        // Test a case with no path from node 2 to node 0 in Graph 1.
        List<Integer> shortestPath = graph1.path(2, 0);
        assertTrue(shortestPath.isEmpty());
    }
}
