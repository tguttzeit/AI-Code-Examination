package Copilot.Dijkstra.BookExampleCode.T7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DijkstraTest {
    @Test
    public void testDijkstra() {
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
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

}