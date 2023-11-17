package ChatGPT.BellmanFord.AIGenerated.T4;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BellmanFordTest {

    @Test
    public void testBellmanFordGraph1() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);

        assertEquals(0, result.get(0).intValue());
        assertEquals(8, result.get(1).intValue());
        assertEquals(6, result.get(2).intValue());
        assertEquals(6, result.get(3).intValue());
        assertEquals(8, result.get(4).intValue());
    }

    @Test
    public void testBellmanFordGraph2() {
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

        assertEquals(0, result.get(0).intValue());
        assertEquals(-1, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
        assertEquals(0, result.get(3).intValue());
        assertEquals(-3, result.get(4).intValue());
    }

    @Test
    public void testBellmanFordGraph3() {
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

        assertEquals(0, result.get(0).intValue());
        assertEquals(-1, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
        assertEquals(0, result.get(3).intValue());
        assertEquals(-3, result.get(4).intValue());
    }

    @Test
    public void testBellmanFordNegativeCycle() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(1, 2, -2),
                new BellmanFord.Edge(2, 0, -3)
        );
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 3);

        assertNull(result);
    }
}
