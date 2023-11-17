package Copilot.BellmanFord.BookExampleCode.T1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class BellmanFordTest {
    @Test
    public void testGraph1(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        Map<Integer, Integer> pathMap = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(3, pathMap.size());
        assertEquals(0, pathMap.get(1).intValue());
        assertEquals(2, pathMap.get(3).intValue());
        assertEquals(2, pathMap.get(4).intValue());
    }

    @Test
    public void testGraph2(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
        Map<Integer, Integer> pathMap = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(4, pathMap.size());
        assertEquals(-1, pathMap.get(1).intValue());
        assertEquals(2, pathMap.get(2).intValue());
        assertEquals(1, pathMap.get(3).intValue());
        assertEquals(-2, pathMap.get(4).intValue());
    }

    @Test
    public void testGraph3(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new Bell
}