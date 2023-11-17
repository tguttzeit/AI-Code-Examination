package Copilot.Kruskal.BookExampleCode.T5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KruskalTest {
    @Test
    public void testKruskal() {
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

        List<Kruskal.Edge> MST = Kruskal.runKruskalAlgorithm(edges, 7);

        assertEquals(MST.size(), 6);
        assertEquals(MST.get(0).weight, 5);
        assertEquals(MST.get(1).weight, 6);
        assertEquals(MST.get(2).weight, 7);
        assertEquals(MST.get(3).weight, 7);
        assertEquals(MST.get(4).weight, 8);
        assertEquals(MST.get(5).weight, 9);
    }

}