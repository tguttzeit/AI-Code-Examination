package ChatGPT.FloydWarshall.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {
    private FloydWarshall floydWarshallGraph1;
    private FloydWarshall floydWarshallGraph2;

    @Before
    public void setUp() {
        // Create instances of FloydWarshall for two graphs
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
    public void testGraph1ShortestPath() {
        List<Integer> path = floydWarshallGraph1.path(0, 4);
        assertNotNull(path);
        assertEquals(0, (int) path.get(0));
        assertEquals(3, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void testGraph2ShortestPath() {
        List<Integer> path = floydWarshallGraph2.path(0, 3);
        assertNotNull(path);
        assertEquals(0, (int) path.get(0));
        assertEquals(2, (int) path.get(1));
        assertEquals(3, (int) path.get(2));
    }

    @Test
    public void testGraph2NegativeWeightCycle() {
        List<Integer> path = floydWarshallGraph2.path(4, 0);
        assertNull(path); // Expecting no path due to negative weight cycle
    }
}
