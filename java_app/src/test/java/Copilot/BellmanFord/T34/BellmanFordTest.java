package Copilot.BellmanFord.T34;
// Test graph was taken from main method: https://www.techiedelight.com/single-source-shortest-paths-bellman-ford-algorithm/
// The expected result is provided as JSON, which should improve readability of the code.
// Jackson translates this json into the needed nested map

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


public class BellmanFordTest {

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
    public void testBellmanFordAllPositiveNoCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, 1), new BellmanFord.Edge(0, 2, 4), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2), new BellmanFord.Edge(1, 4, 2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }


    @Test
    public void testBellmanFordAllPositiveWithCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"1\":1,\"2\":4,\"3\":0,\"4\":3},\"4\":{\"1\":4,\"2\":7,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, 1), new BellmanFord.Edge(0, 2, 4), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2), new BellmanFord.Edge(1, 4, 2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1), new BellmanFord.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }

    @Test
    public void testBellmanFordMixedNoCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":-1,\"2\":-1,\"3\":-6,\"4\":-3},\"1\":{\"1\":0,\"2\":0,\"3\":-5,\"4\":-2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":2,\"3\":-3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1), new BellmanFord.Edge(0, 2, 4), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2), new BellmanFord.Edge(1, 4, -2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, -3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }


    @Test
    public void testBellmanFordMixedWithCycle() throws IOException {
        String json = "{\"0\":{\"0\":0,\"1\":-1,\"2\":2,\"3\":-2,\"4\":1},\"1\":{\"1\":0,\"2\":3,\"3\":-1,\"4\":2},\"2\":{\"2\":0},\"3\":{\"1\":1,\"2\":4,\"3\":0,\"4\":3},\"4\":{\"1\":-2,\"2\":1,\"3\":-3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1), new BellmanFord.Edge(0, 2, 4), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2), new BellmanFord.Edge(1, 4, 2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1), new BellmanFord.Edge(4, 3, -3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }

    @Test
    public void testBellmanFordNegativeCycle() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1), new BellmanFord.Edge(0, 2, 4), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1), new BellmanFord.Edge(4, 3, -3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        for (int source = 0; source < n; source++) {
            if (source != 2) {
                assertNull(BellmanFord.bellmanFord(edges, source, n));
            }else{
                assertNotNull(BellmanFord.bellmanFord(edges, source, n));
            }
        }
    }
    @Test
    public void testBellmanFordOneLoseNode() throws IOException {
        String json = "{\"0\":{\"0\":0},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}";
        expected = new ObjectMapper().readValue(json, typeReference);
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1), new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2), new BellmanFord.Edge(1, 4, 2), new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        // set the maximum number of nodes in the graph
        int n = 5;
        // run the Bellman–Ford algorithm from every node
        generateFromSources(n, edges);
        compareMaps(expected, result);
    }

    // Future work: Test with empty graph

    private void compareMaps(Map<Integer, Map<Integer, Integer>> expected, Map<Integer, Map<Integer, Integer>> result) {
        for (Integer integer : expected.keySet()) {
            Map<Integer, Integer> expectedMap = expected.get(integer);
            Map<Integer, Integer> resultMap = result.get(integer);
            for (Integer integer1 : expectedMap.keySet()) {
                Integer expectedPath = expectedMap.get(integer1);
                Integer resultPath = resultMap.get(integer1);
                assertEquals(expectedPath, resultPath);
            }
        }
    }

    public void generateFromSources(int n, List<BellmanFord.Edge> edges){
        for (int source = 0; source < n; source++) {
            Map<Integer, Integer> source_result = BellmanFord.bellmanFord(edges, source, n);
            if(source_result != null){
                source_result.put(source, 0);
                result.put(source, source_result);
            }
        }
    }
}