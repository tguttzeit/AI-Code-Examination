package Copilot.FloydWarshall.AIGenerated.T4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {
    FloydWarshall floydWarshall = new FloydWarshall(5);

    @Before
    public void setUp() throws Exception {
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
    public void testPath() {
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(4, path.size());
        assertEquals(0, path.get(0).intValue());
        assertEquals(3, path.get(1).intValue());
        assertEquals(1, path.get(2).intValue());
        assertEquals(2, path.get(3).intValue());
    }

    @Test
    public void testRun() {
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(4, path.size());
        assertEquals(0, path.get(0).intValue());
        assertEquals(3, path.get(1).intValue());
        assertEquals(1, path.get(2).intValue());
        assertEquals(2, path.get(3).intValue());
    }

    @Test
    public void testPath2() {
        floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(4, path.size());
        assertEquals(0, path.get(
}