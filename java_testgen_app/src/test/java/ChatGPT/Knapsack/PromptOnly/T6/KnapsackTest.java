package ChatGPT.Knapsack.PromptOnly.T6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithValidInput() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int expected = 11; // The expected maximum value
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithZeroCapacity() {
        Knapsack knapsack = new Knapsack();
        int capacity = 0;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int expected = 0; // The expected maximum value for zero capacity
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithNoItems() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {};
        int[] values = {};
        int expected = 0; // The expected maximum value with no items
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }
}
