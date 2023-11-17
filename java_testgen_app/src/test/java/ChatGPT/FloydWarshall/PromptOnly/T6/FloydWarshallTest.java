package ChatGPT.FloydWarshall.PromptOnly.T6;

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

        List<Integer> path01 = floydWarshall.path(0, 1);
        List<Integer> path04 = floydWarshall.path(0, 4);
        List<Integer> path33 = floydWarshall.path(3, 3);

        assertEquals(7, path01.size());
        assertEquals(3, path04.size());
        assertEquals(0, path33.size());

        assertEquals(0, (int) path01.get(0));
        assertEquals(3, (int) path01.get(1));
        assertEquals(1, (int) path01.get(2));
        assertEquals(4, (int) path01.get(3));
        assertEquals(2, (int) path01.get(4));
        assertEquals(3, (int) path01.get(5));
        assertEquals(1, (int) path01.get(6));

        assertEquals(0, (int) path04.get(0));
        assertEquals(3, (int) path04.get(1));
        assertEquals(4, (int) path04.get(2));

        assertEquals(3, (int) path33.get(0));
        assertEquals(3, (int) path33.get(1));
        assertEquals(3, (int) path33.get(2));
        assertEquals(3, (int) path33.get(3));
        assertEquals(3, (int) path33.get(4));
        assertEquals(3, (int) path33.get(5));
        assertEquals(3, (int) path33.get(6));
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

        List<Integer> path01 = floydWarshall.path(0, 1);
        List<Integer> path04 = floydWarshall.path(0, 4);
        List<Integer> path33 = floydWarshall.path(3, 3);

        assertEquals(0, path01.size());
        assertEquals(0, path04.size());
        assertEquals(0, path33.size());
    }

    @Test
    public void testEmptyGraph() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.run();

        List<Integer> path01 = floydWarshall.path(0, 1);
        List<Integer> path23 = floydWarshall.path(2, 3);

        assertEquals(0, path01.size());
        assertEquals(0, path23.size());
    }
}
