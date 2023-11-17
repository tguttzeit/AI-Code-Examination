package ChatGPT.FloydWarshall.BookExampleCode.T5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FloydWarshallTest {

    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Create Graph 1
        graph1 = new FloydWarshall(5);
        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 3, 5);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(2, 4, 4);
        graph1.addEdge(3, 1, 3);
        graph1.addEdge(3, 2, 9);
        graph1.addEdge(3, 4, 2);
        graph1.addEdge(4, 2, 6);

        // Create Graph 2
        graph2 = new FloydWarshall(5);
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(1, 3, 5);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 4);
        graph2.addEdge(4, 3, 4);
        graph2.addEdge(2, 4, -2);

        // Run Floyd-Warshall algorithm on both graphs
        graph1.run();
        graph2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        // Test shortest path from node 0 to node 4 in Graph 1
        assertEquals(7, graph1.adj[0][4]);
        assertTrue(graph1.path(0, 4).contains(0));
        assertTrue(graph1.path(0, 4).contains(3));
        assertTrue(graph1.path(0, 4).contains(4));
    }

    @Test
    public void testShortestPathGraph2() {
        // Test shortest path from node 0 to node 4 in Graph 2
        assertEquals(3, graph2.adj[0][4]);
        assertTrue(graph2.path(0, 4).contains(0));
        assertTrue(graph2.path(0, 4).contains(2));
        assertTrue(graph2.path(0, 4).contains(4));
    }

    @Test
    public void testShortestPathNonexistent() {
        // Test shortest path from node 0 to node 1 in Graph 2 (should not exist)
        assertEquals(Integer.MAX_VALUE, graph2.adj[0][1]);
        assertTrue(graph2.path(0, 1).isEmpty());
    }
}
