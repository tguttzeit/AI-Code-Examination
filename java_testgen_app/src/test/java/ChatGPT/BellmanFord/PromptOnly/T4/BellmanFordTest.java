package ChatGPT.BellmanFord.PromptOnly.T4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);

        assertNull(result); // Expecting null due to a negative cycle
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

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);

        assertNotNull(result);
        assertEquals(0, (int) result.get(0));
        assertEquals(-1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
        assertEquals(-2, (int) result.get(4));
        assertEquals(3, (int) result.get(3));
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

        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);

        assertNotNull(result);
        assertEquals(0, (int) result.get(0));
        assertEquals(-1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
        assertEquals(4, (int) result.get(3));
        assertEquals(2, (int) result.get(4));
    }
}
