package ChatGPT.FloydWarshall.PromptOnly.T9;

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
        // Initialize the graphs with the specified edges and weights.
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

        // Run Floyd-Warshall algorithm for both graphs.
        graph1.run();
        graph2.run();
    }

    @Test
    public void testPathGraph1() {
        List<Integer> path1 = graph1.path(0, 2);
        List<Integer> path2 = graph1.path(1, 4);
        List<Integer> path3 = graph1.path(0, 0); // Same source and destination

        assertEquals("[0, 3, 1, 2]", path1.toString());
        assertEquals("[1, 3, 4, 2]", path2.toString());
        assertNull(path3); // No path when source and destination are the same
    }

    @Test
    public void testPathGraph2() {
        List<Integer> path1 = graph2.path(0, 3);
        List<Integer> path2 = graph2.path(4, 2);
        List<Integer> path3 = graph2.path(0, 4);

        assertEquals("[0, 2, 3]", path1.toString());
        assertNull(path2); // No path from 4 to 2
        assertNull(path3); // No path from 0 to 4
    }
}
