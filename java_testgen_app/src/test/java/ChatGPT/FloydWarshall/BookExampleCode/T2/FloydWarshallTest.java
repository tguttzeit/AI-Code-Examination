package ChatGPT.FloydWarshall.BookExampleCode.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class FloydWarshallTest {
    private FloydWarshall floydWarshall;

    @Before
    public void setUp() {
        floydWarshall = new FloydWarshall(5); // Assuming 5 nodes for both graphs
        // Graph 1:
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 9);
        floydWarshall.addEdge(3, 4, 2);
        floydWarshall.addEdge(4, 2, 6);
    }

    @Test
    public void testShortestPathGraph1() {
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(List.of(0, 3, 4), path);
    }

    @Test
    public void testShortestPathGraph2() {
        floydWarshall = new FloydWarshall(5); // Reset for Graph 2
        // Graph 2:
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(List.of(0, 2, 4), path);
    }

    @Test
    public void testShortestPathDisconnectedNodes() {
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(List.of(0, 3, 4), path);

        path = floydWarshall.path(0, 4);
        assertEquals(List.of(0, 3, 4), path);

        path = floydWarshall.path(2, 1);
        assertEquals(List.of(2, 3, 1), path);
    }
}
