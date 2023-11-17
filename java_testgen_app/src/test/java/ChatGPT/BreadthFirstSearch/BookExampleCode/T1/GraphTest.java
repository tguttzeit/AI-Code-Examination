package ChatGPT.BreadthFirstSearch.BookExampleCode.T1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testBFSStartingFromNode0() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] resultParent = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode1() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] expectedParent = {1, -1, -1, 0, 3, 3};
        int[] resultParent = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode4() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] expectedParent = {3, 0, 0, 1, -1, 3};
        int[] resultParent = breadthFirstSearch.bfs(4);
        assertArrayEquals(expectedParent, resultParent);
    }
}
