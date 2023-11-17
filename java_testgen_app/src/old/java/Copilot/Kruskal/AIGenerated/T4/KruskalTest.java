package Copilot.Kruskal.AIGenerated.T4;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class KruskalTest {
    @Test
    public void testKruskal1(){
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, 7),
                new Kruskal.Edge(1, 2, 8),
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 3, 9),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(3, 4, 15),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(4, 5, 8),
                new Kruskal.Edge(4, 6, 9),
                new Kruskal.Edge(5, 6, 11)
        );
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 7);
        assertEquals(6, mst.size());
        assertEquals(new Kruskal.Edge(0, 3, 5), mst.get(0));
        assertEquals(new Kruskal.Edge(2, 4, 5), mst.get(1));
        assertEquals(new Kruskal.Edge(3, 5, 6), mst.get(2));
        assertEquals(new Kruskal.Edge(1, 4, 7), mst.get(3));
        assertEquals(new Kruskal.Edge(0, 1, 7), mst.get(4));
        assertEquals(new Kruskal.Edge(4, 6, 9), mst.get(5));
    }
    @Test
    public void testKruskal2(){
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
    }
}