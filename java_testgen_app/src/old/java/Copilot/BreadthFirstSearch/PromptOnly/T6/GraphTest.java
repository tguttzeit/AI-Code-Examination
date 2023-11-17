package Copilot.BreadthFirstSearch.PromptOnly.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        assertEquals(0, graph.addEdge(0, 1));
        assertEquals(1, graph.addEdge(0, 2));
        assertEquals(2, graph.addEdge(1, 3));
        assertEquals(3, graph.addEdge(2, 3));
        assertEquals(4, graph.addEdge(3, 4));
        assertEquals(5, graph.addEdge(3, 5));
    }
    @Test
    public void testBfs() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        assertEquals(0, graph.bfs(0));
        assertEquals(1, graph.bfs(1));
        assertEquals(2, graph.bfs(2));
        assertEquals(3, graph.bfs(3));
        assertEquals(4, graph.bfs(4));
        assertEquals(5, graph.bfs(5));
    }
    @Test
    public void testBfs2() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        assertEquals(0, graph.bfs(0));
        assertEquals(1, graph.bfs(1));
        assertEquals(2, graph.bfs(2));
        assertEquals(-1, graph.bfs(3));
        assertEquals(-1, graph.bfs(4));
        assertEquals(-1, graph.bfs(5));
    }
    @Test
    public void testBfs3() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        assertEquals(0, graph.bfs(0));
        assertEquals(1, graph.bfs(1));
        assertEquals(2, graph.bfs(2));
        assertEquals(3, graph.bfs(3));
        assertEquals(-1, graph.bfs(4));
        assertEquals(-1, graph.bfs(5));
    }


}