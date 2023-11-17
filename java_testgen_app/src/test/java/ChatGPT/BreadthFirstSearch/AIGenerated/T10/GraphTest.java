package ChatGPT.BreadthFirstSearch.AIGenerated.T10;

import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testBfsCase1() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int[] parent = graph.bfs(0);

        // Verify the parent array for each vertex
        assertEquals(-1, parent[0]);
        assertEquals(0, parent[1]);
        assertEquals(0, parent[2]);
        assertEquals(1, parent[3]);
        assertEquals(3, parent[4]);
        assertEquals(3, parent[5]);
    }

    @Test
    public void testBfsCase2() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int[] parent = graph.bfs(0);

        // Verify the parent array for each vertex
        assertEquals(-1, parent[0]);
        assertEquals(0, parent[1]);
        assertEquals(0, parent[2]);
        assertEquals(1, parent[3]);
        assertEquals(2, parent[4]);
    }

    @Test
    public void testBfsCase3() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        int[] parent = graph.bfs(0);

        // Verify the parent array for each vertex
        assertEquals(-1, parent[0]);
        assertEquals(0, parent[1]);
        assertEquals(1, parent[2]);
        assertEquals(2, parent[3]);
    }
}
