package Copilot.Kruskal.BookExampleCode.T8;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class KruskalTest {
    @Test
    public void testRunKruskalAlgorithm1() {
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

        assertEquals(6, MST.size());
        assertEquals("(0, 3, 5)", MST.get(0).toString());
        assertEquals("(2, 4, 5)", MST.get(1).toString());
        assertEquals("(3, 5, 6)", MST.get(2).toString());
        assertEquals("(0, 1, 7)", MST.get(3).toString());
        assertEquals("(1, 4, 7)", MST.get(4).toString());
        assertEquals("(4, 6, 9)", MST.get(5).toString());
    }

    @Test
    public void testRunKruskalAlgorithm2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> MST = Kruskal.runKruskalAlgorithm(edges, 5);

}