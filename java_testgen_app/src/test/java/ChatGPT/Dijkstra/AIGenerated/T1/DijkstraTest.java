package ChatGPT.Dijkstra.AIGenerated.T1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.*;

public class DijkstraTest {

    // Test Graph 1
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

        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(1, shortestPaths.get(1).intValue());
        assertEquals(4, shortestPaths.get(2).intValue());
        assertEquals(3, shortestPaths.get(3).intValue());
        assertEquals(3, shortestPaths.get(4).intValue());
    }

    // Test Graph 2
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

        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(1, shortestPaths.get(1).intValue());
        assertEquals(4, shortestPaths.get(2).intValue());
        assertEquals(3, shortestPaths.get(3).intValue());
        assertEquals(3, shortestPaths.get(4).intValue());
    }

    // Test Graph 3
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
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(1, shortestPaths.size());
        assertEquals(0, shortestPaths.get(0).intValue());
    }
}
