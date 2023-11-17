package Copilot.Kruskal.AIGenerated.T1;

import org.junit.Test;
import static org.junit.Assert.*;
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
                new Kruskal.Edge(5, 6, 11));
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 7);
        int sum = 0;
        for (Kruskal.Edge e : mst) {
            sum += e.weight;
        }
        assertEquals(39, sum);
    }

    @Test
    public void test2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2));
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);
        int sum = 0;
        for (Kruskal.Edge e : mst) {
            sum += e.weight;
        }
        assertEquals(2, sum);
    }

    @Test
    public void test3() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, 7),
                new Kruskal.Edge(1, 2, 8));
    }
}