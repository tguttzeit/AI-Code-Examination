package ChatGPT.FloydWarshall.BookExampleCode.T10;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class FloydWarshallTest {
    private FloydWarshall floydWarshall1;
    private FloydWarshall floydWarshall2;

    @Before
    public void setUp() {
        // Create the first graph
        floydWarshall1 = new FloydWarshall(5);
        floydWarshall1.addEdge(0, 1, 10);
        floydWarshall1.addEdge(0, 3, 5);
        floydWarshall1.addEdge(1, 3, 2);
        floydWarshall1.addEdge(1, 2, 1);
        floydWarshall1.addEdge(2, 4, 4);
        floydWarshall1.addEdge(3, 1, 3);
        floydWarshall1.addEdge(3, 2, 9);
        floydWarshall1.addEdge(3, 4, 2);
        floydWarshall1.addEdge(4, 2, 6);

        // Create the second graph
        floydWarshall2 = new FloydWarshall(5);
        floydWarshall2.addEdge(0, 2, 5);
        floydWarshall2.addEdge(1, 3, 5);
        floydWarshall2.addEdge(2, 3, 4);
        floydWarshall2.addEdge(3, 2, 4);
        floydWarshall2.addEdge(4, 3, 4);
        floydWarshall2.addEdge(2, 4, -2);

        // Run Floyd-Warshall algorithm on both graphs
        floydWarshall1.run();
        floydWarshall2.run();
    }

    @Test
    public void testShortestPath1() {
        List<Integer> path = floydWarshall1.path(0, 4);
        assertEquals(List.of(0, 3, 4), path);
    }

    @Test
    public void testShortestPath2() {
        List<Integer> path = floydWarshall1.path(1, 4);
        assertEquals(List.of(1, 3, 4), path);
    }

    @Test
    public void testShortestPath3() {
        List<Integer> path = floydWarshall2.path(0, 3);
        assertEquals(List.of(0, 2, 3), path);
    }
}
