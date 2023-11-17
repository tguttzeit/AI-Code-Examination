package ChatGPT.BellmanFord.BookExampleCode.T8;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BellmanFordTest {

    @Test
    public void testGraph1() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        int source = 0;
        int n = 5; // Number of nodes

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);

        // Expected shortest path distances from source
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 0);
        expected.put(2, 8);
        expected.put(3, 5);
        expected.put(4, 7);

        assertEquals(expected, result);
    }

    @Test
    public void testGraph2() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
        int source = 0;
        int n = 5; // Number of nodes

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);

        // Expected shortest path distances from source
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, -1);
        expected.put(2, 2);
        expected.put(3, -2);
        expected.put(4, 1);

        assertEquals(expected, result);
    }

    @Test
    public void testGraph3() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
        int source = 0;
        int n = 5; // Number of nodes

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);

        // Expected shortest path distances from source
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, -1);
        expected.put(2, 2);
        expected.put(3, -2);
        expected.put(4, 1);

        assertEquals(expected, result);
    }
}
