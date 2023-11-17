package ChatGPT.FloydWarshall.BookExampleCode.T6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FloydWarshallTest {
    private FloydWarshall floydWarshall1;
    private FloydWarshall floydWarshall2;

    @Before
    public void setUp() {
        // Create two instances of FloydWarshall for testing
        floydWarshall1 = new FloydWarshall(5);
        floydWarshall2 = new FloydWarshall(5);

        // Build graph 1
        floydWarshall1.addEdge(0, 1, 10);
        floydWarshall1.addEdge(0, 3, 5);
        floydWarshall1.addEdge(1, 3, 2);
        floydWarshall1.addEdge(1, 2, 1);
        floydWarshall1.addEdge(2, 4, 4);
        floydWarshall1.addEdge(3, 1, 3);
        floydWarshall1.addEdge(3, 2, 9);
        floydWarshall1.addEdge(3, 4, 2);
        floydWarshall1.addEdge(4, 2, 6);

        // Build graph 2
        floydWarshall2.addEdge(0, 2, 5);
        floydWarshall2.addEdge(1, 3, 5);
        floydWarshall2.addEdge(2, 3, 4);
        floydWarshall2.addEdge(3, 2, 4);
        floydWarshall2.addEdge(4, 3, 4);
        floydWarshall2.addEdge(2, 4, -2);

        // Run the algorithm for both graphs
        floydWarshall1.run();
        floydWarshall2.run();
    }

    @Test
    public void testShortestPathGraph1() {
        List<Integer> path = floydWarshall1.path(0, 4);
        assertEquals(4, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(1), path.get(2));
        assertEquals(Integer.valueOf(4), path.get(3));
    }

    @Test
    public void testShortestPathGraph2() {
        List<Integer> path = floydWarshall2.path(0, 3);
        assertEquals(3, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(2), path.get(1));
        assertEquals(Integer.valueOf(3), path.get(2));
    }

    @Test
    public void testNegativeWeightCycleGraph2() {
        // Check if there's a negative weight cycle in graph 2
        // In this case, there shouldn't be a path from 4 to 0 since it has a negative
        // cycle
        List<Integer> path = floydWarshall2.path(4, 0);
        assertTrue(path.isEmpty());
    }
}
