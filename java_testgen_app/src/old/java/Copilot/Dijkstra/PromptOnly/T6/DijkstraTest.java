package Copilot.Dijkstra.PromptOnly.T6;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DijkstraTest {
    @Test
    public void testOnlyPositiveEdgeCosts() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        Dijkstra d = new Dijkstra(edges, 5);
        assertTrue(d.onlyPositiveEdgeCosts());
    }

    @Test
    public void testFindShortestPaths() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        Dijkstra d = new Dijkstra(edges, 5);
        Map<Integer, Integer> shortestPaths = d.findShortestPaths(0);
        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(1, shortestPaths.get(1).intValue());
        assertEquals(4, shortestPaths.get(2).intValue());
        assertEquals(3, shortestPaths.get(3).intValue());
        assertEquals(3, shortestPaths.get(4).intValue());
    }

    @Test
    public void testFindShortestPaths2() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3,



    }