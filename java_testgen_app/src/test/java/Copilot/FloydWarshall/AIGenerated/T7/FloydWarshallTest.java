package Copilot.FloydWarshall.AIGenerated.T7;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class FloydWarshallTest {
    FloydWarshall floydWarshall;

    @Before
    public void setUp() {
        floydWarshall = new FloydWarshall(5);
    }

    @Test
    public void testPath() {
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
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(3, path.size());
        assertEquals(0, (int) path.get(0));
        assertEquals(3, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void testPath2() {
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(3, path.size());
        assertEquals(0, (int) path.get(0));
        assertEquals(2, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void testPath3() {
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
    }
}