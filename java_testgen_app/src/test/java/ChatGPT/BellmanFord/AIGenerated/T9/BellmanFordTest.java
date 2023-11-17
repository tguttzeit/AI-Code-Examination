package ChatGPT.BellmanFord.AIGenerated.T9;

import org.junit.Test;

import java.util.Arrays;
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
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);

        // Expected distances from source 0
        int[] expectedDistances = {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int vertex = entry.getKey();
            int distance = entry.getValue();
            assertEquals(expectedDistances[vertex], distance);
        }
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

        // Expected distances from source 0
        int[] expectedDistances = {0, -1, 2, 0, -2};

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int vertex = entry.getKey();
            int distance = entry.getValue();
            assertEquals(expectedDistances[vertex], distance);
        }
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

        // Expected distances from source 0
        int[] expectedDistances = {0, -1, 2, 0, -2};

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int vertex = entry.getKey();
            int distance = entry.getValue();
            assertEquals(expectedDistances[vertex], distance);
        }
    }
}
