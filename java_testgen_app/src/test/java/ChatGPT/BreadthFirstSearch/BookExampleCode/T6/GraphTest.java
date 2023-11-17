package ChatGPT.BreadthFirstSearch.BookExampleCode.T6;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    @Test
    public void testBFS1() {
        Graph graph = new Graph(6);

        // Build the graph with the provided edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int[] result = graph.bfs(0);
        int[] expected = {-1, 0, 0, 1, 3, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testBFS2() {
        Graph graph = new Graph(5);

        // Build a simpler graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int[] result = graph.bfs(0);
        int[] expected = {-1, 0, 0, 1, 2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testBFS3() {
        Graph graph = new Graph(7);

        // Build another graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);

        int[] result = graph.bfs(0);
        int[] expected = {-1, 0, 0, 1, 2, 3, 3};

        assertArrayEquals(expected, result);
    }
}
