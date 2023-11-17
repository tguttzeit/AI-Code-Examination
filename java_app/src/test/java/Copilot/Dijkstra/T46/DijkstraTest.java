package Copilot.Dijkstra.T46;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DijkstraTest {

    private int n;
    private static TypeReference<Map<Integer, Map<Integer, Integer>>> typeReference;
    private Map<Integer, Map<Integer, Integer>> result;
    private Map<Integer, Map<Integer, Integer>> expected;
    @BeforeClass
    public static void classSetup() {
        typeReference = new TypeReference<>() {
        };
    }

    @Before
    public void testSetup() {
        result = new HashMap<>();
        expected = new HashMap<>();
    }


    @Test
    public void testDijkstraAllPositiveNoCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1), new Dijkstra.Edge(0, 2, 4), new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2), new Dijkstra.Edge(1, 4, 2), new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        n = 5;
        // run the Dijkstra algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }


    @Test
    public void testDijkstraAllPositiveWithCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"1\":1,\"2\":4,\"3\":0,\"4\":3},\"4\":{\"1\":4,\"2\":7,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1), new Dijkstra.Edge(0, 2, 4), new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2), new Dijkstra.Edge(1, 4, 2), new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1), new Dijkstra.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        n = 5;
        // run the Dijkstra algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }

    @Test
    public void testDijkstraOneLoseNode() throws IOException {
        String json = "{\"0\":{\"0\":0},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1), new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2), new Dijkstra.Edge(1, 4, 2), new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        n = 5;
        // run the Dijkstra algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }

    private void compareMaps(Map<Integer, Map<Integer, Integer>> expected, Map<Integer, Map<Integer, Integer>> result) {
        for (Integer integer : expected.keySet()) {
            Map<Integer, Integer> expectedMap = expected.get(integer);
            Map<Integer, Integer> resultMap = result.get(integer);
            for (Integer integer1 : expectedMap.keySet()) {
                int expectedPath = expectedMap.get(integer1);
                int resultPath = resultMap.get(integer1);
                assertEquals(expectedPath, resultPath);
            }
        }
    }

    public void generateFromSources(int n, List<Dijkstra.Edge> edges){
        for (int source = 0; source < n; source++) {
            Map<Integer, Integer> source_result = new Dijkstra(edges, n).findShortestPaths(source);
            if(source_result != null){
                source_result.put(source, 0);
                result.put(source, source_result);
            }
        }
    }
}