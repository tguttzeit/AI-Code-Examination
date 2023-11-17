package ChatGPT.FloydWarshall.BookExampleCode.T8;

import static org.junit.Assert.*;
import org.junit.Test;
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

        // Test the shortest path from node 0 to node 4
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(5, floydWarshall.adj[0][4]);
        assertEquals(5, path.size());
        assertArrayEquals(new Integer[] { 0, 3, 4 }, path.toArray());
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

        // Test the shortest path from node 1 to node 0
        List<Integer> path = floydWarshall.path(1, 0);
        assertEquals(Integer.MAX_VALUE, floydWarshall.adj[1][0]);
        assertTrue(path.isEmpty());
    }

    @Test
    public void testEmptyGraph() {
        FloydWarshall floydWarshall = new FloydWarshall(3);
        floydWarshall.run();

        // Test an empty graph
        List<Integer> path = floydWarshall.path(0, 2);
        assertEquals(Integer.MAX_VALUE, floydWarshall.adj[0][2]);
        assertTrue(path.isEmpty());
    }
}
