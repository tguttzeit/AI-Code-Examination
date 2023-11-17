package ChatGPT.Kruskal.AIGenerated.T5;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

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

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 7);

        // Check if the minimum spanning tree contains the expected number of edges
        Assert.assertEquals(6, mst.size());

        // Check if the total weight of the minimum spanning tree is as expected
        int totalWeight = mst.stream().mapToInt(e -> e.weight).sum();
        Assert.assertEquals(39, totalWeight);
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

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);

        // Check if the minimum spanning tree contains the expected number of edges
        Assert.assertEquals(4, mst.size());

        // Check if the total weight of the minimum spanning tree is as expected
        int totalWeight = mst.stream().mapToInt(e -> e.weight).sum();
        Assert.assertEquals(3, totalWeight);
    }

    // Add more test cases as needed

}
