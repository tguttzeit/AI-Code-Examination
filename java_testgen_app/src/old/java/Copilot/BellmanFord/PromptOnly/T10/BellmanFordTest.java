package Copilot.BellmanFord.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    List<BellmanFord.Edge> edges = Arrays.asList(
            new BellmanFord.Edge(0, 0, 1),
            new BellmanFord.Edge(1, 2, 3),
            new BellmanFord.Edge(1, 3, 2),
            new BellmanFord.Edge(1, 4, 2),
            new BellmanFord.Edge(3, 2, 5),
            new BellmanFord.Edge(4, 3, 3)
    );
    List<BellmanFord.Edge> edges = Arrays.asList(
            new BellmanFord.Edge(0, 1, -1),
            new BellmanFord.Edge(0, 2, 4),
            new BellmanFord.Edge(1, 2, 3),
            new BellmanFord.Edge(1, 4, -2),
            new BellmanFord.Edge(3, 2, 5),
            new BellmanFord.Edge(3, 1, 1),
            new BellmanFord.Edge(4, 3, -3)
    );
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
    @Test
    public void test1(){
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, map.get(0));
        assertEquals(1, map.get(1));
        assertEquals(3, map.get(2));
        assertEquals(3, map.get(3));
        assertEquals(5, map.get(4));
    }
    @Test
    public void test2(){
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0,

}