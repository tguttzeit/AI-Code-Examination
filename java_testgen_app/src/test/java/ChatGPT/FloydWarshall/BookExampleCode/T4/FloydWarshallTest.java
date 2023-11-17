package ChatGPT.FloydWarshall.BookExampleCode.T4;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class FloydWarshallTest {

    @Test
    public void testGraph1ShortestPath() {
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

        assertEquals(5, floydWarshall.adj[0][4]);
        assertEquals(List.of(0, 3, 4), path);
    }

    @Test
    public void testGraph2ShortestPath() {
        FloydWarshall floydWarshall = new FloydWarshall(5);

        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        floydWarshall.run();

        List<Integer> path = floydWarshall.path(0, 3);

        assertEquals(9, floydWarshall.adj[0][3]);
        assertEquals(List.of(0, 2, 3), path);
    }

    @Test
    public void testGraph1ToGraph2ShortestPath() {
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

        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);

        floydWarshall.run();

        List<Integer> path = floydWarshall.path(0, 3);

        assertEquals(7, floydWarshall.adj[0][3]);
        assertEquals(List.of(0, 3), path);
    }
}
