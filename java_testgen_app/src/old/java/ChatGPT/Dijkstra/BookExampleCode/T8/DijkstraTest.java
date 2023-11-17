package ChatGPT.Dijkstra.BookExampleCode.T8;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DijkstraTest {

    @Test
    public void testShortestPathsGraph1() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        Dijkstra dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, shortestPaths.get(0));
        assertEquals(1, shortestPaths.get(1));
        assertEquals(4, shortestPaths.get(2));
        assertEquals(3, shortestPaths.get(3));
        assertEquals(3, shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph2() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1),
                new Dijkstra.Edge(4, 3, 3)
        );

        Dijkstra dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, shortestPaths.get(0));
        assertEquals(1, shortestPaths.get(1));
        assertEquals(4, shortestPaths.get(2));
        assertEquals(3, shortestPaths.get(3));
        assertEquals(3, shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph3() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        Dijkstra dijkstra = new Dijkstra(edges, 5);

        // Since the first graph has a self-loop with a weight of 1, there is no shortest path from node 0 to other nodes.
        // Therefore, the expected result is null.
        assertNull(dijkstra.findShortestPaths(0));
    }
}
