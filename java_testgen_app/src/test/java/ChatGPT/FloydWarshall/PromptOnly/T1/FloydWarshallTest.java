package ChatGPT.FloydWarshall.PromptOnly.T1;

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
        // Build Graph 1
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

        // Build Graph 2
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
    public void testPathExistsInGraph1() {
        List<Integer> path = graph1.path(0, 2);
        assertEquals(3, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(4), path.get(2));
    }

    @Test
    public void testNoPathInGraph1() {
        assertNull(graph1.path(2, 0));
    }

    @Test
    public void testNegativeWeightCycleInGraph2() {
        assertNull(graph2.path(4, 0));
    }
}
