package ChatGPT.Dijkstra.AIGenerated.T6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class DijkstraTest {

    @Test
    public void testGraph1() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        Dijkstra dijkstra = new Dijkstra(edges, 5); // 5 is the number of vertices in the graph
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Expected shortest path distances from source vertex 0
        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(0, 0);
        expectedDistances.put(1, 1);
        expectedDistances.put(2, 4);
        expectedDistances.put(3, 3);
        expectedDistances.put(4, 3);

        assertEquals(expectedDistances, shortestPaths);
    }

    @Test
    public void testGraph2() {
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

        Dijkstra dijkstra = new Dijkstra(edges, 5); // 5 is the number of vertices in the graph
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Expected shortest path distances from source vertex 0
        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(0, 0);
        expectedDistances.put(1, 1);
        expectedDistances.put(2, 4);
        expectedDistances.put(3, 3);
        expectedDistances.put(4, 3);

        assertEquals(expectedDistances, shortestPaths);
    }

    @Test
    public void testGraph3() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        Dijkstra dijkstra = new Dijkstra(edges, 2); // 2 is the number of vertices in the graph
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Expected shortest path distances from source vertex 0
        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(0, 0);

        assertEquals(expectedDistances, shortestPaths);
    }
}
