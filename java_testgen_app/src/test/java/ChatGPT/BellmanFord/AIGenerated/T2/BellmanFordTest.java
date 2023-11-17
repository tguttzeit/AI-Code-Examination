package ChatGPT.BellmanFord.AIGenerated.T2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    @Before
    public void setUp() {
        // You can set up any common initialization here.
    }

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

        // Add your assertions for Graph 1 here.
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

        // Add your assertions for Graph 2 here.
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

        // Add your assertions for Graph 3 here.
    }
}
