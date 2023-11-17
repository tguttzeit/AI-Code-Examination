package Copilot.Kruskal.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class KruskalTest {
    // test case 1
    @Test
    public void testKruskal1() {
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
        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 7);
        int expected = 39;
        int actual = 0;
        for (Kruskal.Edge e : result) {
            actual += e.weight;
        }
        assertEquals(expected, actual);
    }

    // test case 2
    @Test
    public void testKruskal2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2));
        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 5);
        int expected = 0;
        int actual = 0;
        for (Kruskal.Edge e : result) {
            actual += e.weight;
        }
        assertEquals(expected, actual);
    }

    // test case 3
    @Test
    public void testKruskal3() {
        List k;
    }
}
