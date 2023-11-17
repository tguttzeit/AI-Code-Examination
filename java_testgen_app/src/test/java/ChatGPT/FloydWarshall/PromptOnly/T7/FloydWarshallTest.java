package ChatGPT.FloydWarshall.PromptOnly.T7;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {

    @Test
    public void testGraph1() {
        FloydWarshall floydWarshall = new FloydWarshall(5);

        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 9);
        floydWarshall.addEdge(3, 4, 2);
        floydWarshall.addEdge(4, 2, 6);

        floydWarshall.run();

        // Test the path from node 0 to node 4
        List<Integer> path = floydWarshall.path(0, 4);
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(1), path.get(2));
        assertEquals(Integer.valueOf(4), path.get(3));

        // Test the path from node 0 to itself (should be skipped)
        path = floydWarshall.path(0, 0);
        assertNull(path);

        // Test the path from node 2 to node 3
        path = floydWarshall.path(2, 3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(Integer.valueOf(2), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
    }

    @Test
    public void testGraph2() {
        FloydWarshall floydWarshall = new FloydWarshall(5);

        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        floydWarshall.run();

        // Test the path from node 1 to node 0 (no path)
        List<Integer> path = floydWarshall.path(1, 0);
        assertNull(path);

        // Test the path from node 2 to node 3
        path = floydWarshall.path(2, 3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(Integer.valueOf(2), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));

        // Test the path from node 0 to itself (should be skipped)
        path = floydWarshall.path(0, 0);
        assertNull(path);
    }

    @Test
    public void testEmptyGraph() {
        FloydWarshall floydWarshall = new FloydWarshall(3);
        floydWarshall.run();

        // Test the path from node 0 to node 1 (no path)
        List<Integer> path = floydWarshall.path(0, 1);
        assertNull(path);

        // Test the path from node 2 to itself (should be skipped)
        path = floydWarshall.path(2, 2);
        assertNull(path);
    }
}
