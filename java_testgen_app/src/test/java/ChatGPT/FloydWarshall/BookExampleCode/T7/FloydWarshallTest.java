package ChatGPT.FloydWarshall.BookExampleCode.T7;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FloydWarshallTest {
    private FloydWarshall floydWarshall1;
    private FloydWarshall floydWarshall2;

    @Before
    public void setUp() {
        // Initialize the FloydWarshall instances and build the graphs.
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

        floydWarshall2 = new FloydWarshall(5);
        floydWarshall2.addEdge(0, 2, 5);
        floydWarshall2.addEdge(1, 3, 5);
        floydWarshall2.addEdge(2, 3, 4);
        floydWarshall2.addEdge(3, 2, 4);
        floydWarshall2.addEdge(4, 3, 4);
        floydWarshall2.addEdge(2, 4, -2);
    }

    @Test
    public void testShortestPath1() {
        floydWarshall1.run();
        List<Integer> path = floydWarshall1.path(0, 4);
        assertEquals(3, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(4), path.get(2));
    }

    @Test
    public void testShortestPath2() {
        floydWarshall1.run();
        List<Integer> path = floydWarshall1.path(1, 2);
        assertEquals(3, path.size());
        assertEquals(Integer.valueOf(1), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(2), path.get(2));
    }

    @Test
    public void testShortestPath3() {
        floydWarshall2.run();
        List<Integer> path = floydWarshall2.path(0, 3);
        assertEquals(2, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(2), path.get(1));
    }
}
