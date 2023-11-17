package ChatGPT.Kruskal.T16;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class KruskalTest {

    //test 1 is the book main example
    @Test
    public void test1() throws IllegalAccessException {
        //Number of nodes
        int n = 7;
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, 7), new Kruskal.Edge(1, 2, 8), new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 3, 9), new Kruskal.Edge(1, 4, 7), new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(3, 4, 15), new Kruskal.Edge(3, 5, 6), new Kruskal.Edge(4, 5, 8),
                new Kruskal.Edge(4, 6, 9), new Kruskal.Edge(5, 6, 11));

        KruskalTest.TestResults tr = KruskalTest.TestResults.evaluateResults(Kruskal.runKruskalAlgorithm(edges, n));

        Set<Integer> expectedNodes = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        int expectedCosts = 39;
        assertEquals(expectedCosts, tr.determinedCosts);
        assertEquals(expectedNodes, tr.nodes);
    }

    @Test
    public void test2() throws IllegalAccessException {
        //Number of nodes
        int n = 5;
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3), new Kruskal.Edge(0, 4, 1), new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9), new Kruskal.Edge(2, 4, 3), new Kruskal.Edge(4, 3, 2));

        KruskalTest.TestResults tr = KruskalTest.TestResults.evaluateResults(Kruskal.runKruskalAlgorithm(edges, n));

        Set<Integer> expectedNodes = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4));
        int expectedCosts = 3;
        assertEquals(expectedCosts, tr.determinedCosts);
        assertEquals(expectedNodes, tr.nodes);
    }

    static class TestResults {
        public final int determinedCosts;
        public final Set<Integer> nodes;

        private TestResults(int determinedCosts, Set<Integer> nodes) {
            this.determinedCosts = determinedCosts;
            this.nodes = nodes;
        }

        public static KruskalTest.TestResults evaluateResults(List<Kruskal.Edge> list) throws IllegalAccessException {
            int sum = 0;
            List<Integer> nodes = new ArrayList<>();
            for (Kruskal.Edge edge : list) {
                sum += edge.weight;
                nodes.add(edge.src);
                nodes.add(edge.dest);
            }
            Set<Integer> set = new HashSet<>(nodes);
            return new KruskalTest.TestResults(sum, set);
        }
    }
}
