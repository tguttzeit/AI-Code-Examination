package ChatGPT.Dijkstra.BookExampleCode.T1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DijkstraTest {

    // Helper method to compare two maps
    private boolean compareMaps(Map<Integer, Integer> expected, Map<Integer, Integer> actual) {
        if (expected.size() != actual.size()) return false;
        for (Map.Entry<Integer, Integer> entry : expected.entrySet()) {
            Integer actualValue = actual.get(entry.getKey());
            if (actualValue == null || !actualValue.equals(entry.getValue())) return false;
        }
        return true;
    }

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

        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertTrue(compareMaps(expectedPaths, shortestPaths));
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

        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertTrue(compareMaps(expectedPaths, shortestPaths));
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

        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // No valid paths in this graph, so the result should be an empty map.
        Map<Integer, Integer> expectedPaths = new HashMap<>();

        assertTrue(compareMaps(expectedPaths, shortestPaths));
    }
}
