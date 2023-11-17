package ChatGPT.Kruskal.PromptOnly.T2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KruskalTest {

    @Test
    public void testKruskalAlgorithmGraph1() {
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

        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(4, 6, 9)
        );

        List<Kruskal.Edge> actualMST = Kruskal.runKruskalAlgorithm(edges, 7);
        assertEquals(expectedMST, actualMST);
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(2, 4, 3)
        );

        List<Kruskal.Edge> actualMST = Kruskal.runKruskalAlgorithm(edges, 5);
        assertEquals(expectedMST, actualMST);
    }

    // Add more test cases as needed.

}
