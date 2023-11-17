package Copilot.BreadthFirstSearch.BookExampleCode.T6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    @Test
    public void testBfs() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int[] expected = { -1, 0, 0, 1, 2, 3 };
        int[] actual = graph.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBfs2() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int[] expected = { -1, 0, 0, -1, 3, 3 };
        int[] actual = graph.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBfs3() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int[] expected = { -1, 0, 0, -1, 3, 3 };
        int[] actual = graph.bfs(1);
        assertArrayEquals(expected, actual);
    }




}