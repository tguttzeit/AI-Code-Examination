package BookExamples;

// Source: https://github.com/TrainingByPackt/Data-Structures-and-Algorithms-in-Java/blob/master/src/test/java/com/packt/datastructuresandalg/lesson6/activity/floydwarshall/FloydWarshallTest.java

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FloydWarshallTest extends TestCase {
    public void test_positive_weights() {
        FloydWarshall f = new FloydWarshall(5);
        f.addEdge(0, 1, 10);
        f.addEdge(0, 3, 5);
        f.addEdge(1, 3, 2);
        f.addEdge(1, 2, 1);
        f.addEdge(2, 4, 4);
        f.addEdge(3, 1, 3);
        f.addEdge(3, 2, 9);
        f.addEdge(3, 4, 2);
        f.addEdge(4, 2, 6);
        f.run();

        assertTrue(f.path(0, 0).equals(List.of(0)) || f.path(0, 0).equals(Collections.emptyList()));
        assertEquals(f.path(0, 1), Arrays.asList(0, 3, 1));
        assertEquals(f.path(0, 2), Arrays.asList(0, 3, 1, 2));
        assertEquals(f.path(0, 3), Arrays.asList(0, 3));
        assertEquals(f.path(0, 4), Arrays.asList(0, 3, 4));
        assertEquals(f.path(1, 4), Arrays.asList(1, 3, 4));
    }

    public void test_mixed_weights() {
        FloydWarshall f = new FloydWarshall(100);
        f.addEdge(0, 2, 5);
        f.addEdge(1, 3, 5);
        f.addEdge(2, 3, 4);
        f.addEdge(3, 2, 4);
        f.addEdge(4, 3, 4);
        f.addEdge(2, 4, -2);
        f.run();

        assertEquals(f.path(0, 3), Arrays.asList(0, 2, 4, 3));
        assertEquals(f.path(1, 4), Arrays.asList(1, 3, 2, 4));
    }
}
