package Copilot.Kruskal.BookExampleCode.T4;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class KruskalTest {
    @Test
    public void test1() {
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
        assertEquals(MST.get(1).weight, 5);
        assertEquals(MST.get(2).weight, 6);
        assertEquals(MST.get(3).weight, 7);
        assertEquals(MST.get(4).weight, 7);
        assertEquals(MST.get(5).weight, 8);
    }

    @Test
    public void test2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> MST = Kruskal.runKruskalAlgorithm(edges, 5);

        assertEquals(MST.size(), 4);
        assertEquals(MST.get(0).weight, -3);
        assertEquals(MST.get(1).weight, 1);
        assertEquals(MST.get
}