package Copilot.FloydWarshall.BookExampleCode.T5;

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
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(0, path.get(0).intValue());
        assertEquals(3, path.get(1).intValue());
        assertEquals(4, path.get(2).intValue());

        path = floydWarshall.path(0, 2);
        assertEquals(0, path.get(0).intValue());
        assertEquals(3, path.get(1).intValue());
        assertEquals(1, path.get(2).intValue());
        assertEquals(2, path.get(3).intValue());

        path = floydWarshall.path(0, 0);
        assertEquals(0, path.get(0).intValue());

        path = floydWarshall.path(4, 0);
        assertEquals(4, path.get(0).intValue());
        assertEquals(2, path.get(1).intValue());
        assertEquals(1, path.get(2).intValue());
        assertEquals(3, path.get(3).intValue());
        assertEquals(0, path.get(4).intValue());
    }

    @Test
    public void testGraph2() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 0, 0);
    }
}