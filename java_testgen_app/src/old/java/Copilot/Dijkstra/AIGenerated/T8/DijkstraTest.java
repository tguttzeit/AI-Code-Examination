package Copilot.Dijkstra.AIGenerated.T8;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
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
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);
        expected.put(2, 4);
        expected.put(3, 3);
        expected.put(4, 3);
        assertEquals(expected, map);
    }

    @Test
    public void testFindShortestPaths2() {
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
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);
        expected.put(2, 4);
        expected.put(3, 3);
        expected.put(4, 3);
        assertEquals(expected, map);
    }

    @Test
    public void testFindShortestPaths3() {
        List<Dijkstra.Edge> edges


    }