package ChatGPT.FloydWarshall.PromptOnly.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;

public class FloydWarshallTest {
    private FloydWarshall graph1;
    private FloydWarshall graph2;

    @Before
    public void setUp() {
        // Initialize the graphs with the provided edges and weights
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

        graph2 = new FloydWarshall(5);
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(1, 3, 5);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 4);
        graph2.addEdge(4, 3, 4);
        graph2.addEdge(2, 4, -2);

        // Run the Floyd-Warshall algorithm for the graphs
        graph1.run();
        graph2.run();
    }

    @Test
    public void testGraph1ShortestPath() {
        // Test shortest path from node 0 to node 4 in graph 1
        List<Integer> path = graph1.path(0, 4);
        assertEquals(3, path.size());
        assertEquals(0, (int) path.get(0));
        assertEquals(3, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void testGraph2ShortestPath() {
        // Test shortest path from node 1 to node 2 in graph 2
        List<Integer> path = graph2.path(1, 2);
        assertEquals(2, path.size());
        assertEquals(1, (int) path.get(0));
        assertEquals(3, (int) path.get(1));
    }

    @Test
    public void testNoPath() {
        // Test nodes with no path in graph 1
        assertNull(graph1.path(4, 0)); // No path from 4 to 0
        assertNull(graph1.path(2, 3)); // No path from 2 to 3
    }
}
