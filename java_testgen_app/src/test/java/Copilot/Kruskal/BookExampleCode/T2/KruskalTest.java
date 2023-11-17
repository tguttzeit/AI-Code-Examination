package Copilot.Kruskal.BookExampleCode.T2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
public class KruskalTest {
    @Test
    public void testKruskalAlgorithm() {
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

        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, 7),
                new Kruskal.Edge(1, 2, 8),
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(4, 6, 9)
        );

        assertEquals(expectedMST, MST);
    }

}