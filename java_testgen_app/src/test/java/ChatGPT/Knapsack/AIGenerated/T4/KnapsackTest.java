package ChatGPT.Knapsack.AIGenerated.T4;

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
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int expected = 7; // Maximum value should be 7 (items 1 and 4)
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase2() {
        int capacity = 5;
        int[] weights = {1, 2, 3, 4};
        int[] values = {2, 4, 4, 5};
        int expected = 7; // Maximum value should be 7 (items 2 and 4)
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase3() {
        int capacity = 8;
        int[] weights = {3, 2, 2};
        int[] values = {4, 3, 3};
        int expected = 7; // Maximum value should be 7 (items 1 and 2)
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }
}
