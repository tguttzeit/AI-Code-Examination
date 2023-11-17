package Copilot.BellmanFord.AIGenerated.T9;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    @Test
    public void testBellmanFord1(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, map.get(0));
        assertEquals(1000000000, map.get(1));
        assertEquals(1000000000, map.get(2));
        assertEquals(1000000000, map.get(3));
        assertEquals(1000000000, map.get(4));
    }
    @Test
    public void testBellmanFord2(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, map.get(0));
        assertEquals(-1, map.get(1));
        assertEquals(2, map.get(2));
        assertEquals(-2, map.get(3));
        assertEquals(1, map.get(4));
    }
    @Test
    public void testBellmanFord3(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2
}