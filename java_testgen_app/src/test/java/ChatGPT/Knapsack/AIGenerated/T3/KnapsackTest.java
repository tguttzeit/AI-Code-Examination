package ChatGPT.Knapsack.AIGenerated.T3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    private Knapsack knapsack;

    @Before
    public void setUp() {
        knapsack = new Knapsack();
    }

    @Test
    public void testKnapsackCase1() {
        int capacity = 5;
        int[] weights = {2, 1, 3, 4};
        int[] values = {10, 6, 12, 8};
        int expected = 14;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase2() {
        int capacity = 7;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int expected = 9;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase3() {
        int capacity = 3;
        int[] weights = {2, 2, 2};
        int[] values = {3, 4, 4};
        int expected = 8;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }
}
