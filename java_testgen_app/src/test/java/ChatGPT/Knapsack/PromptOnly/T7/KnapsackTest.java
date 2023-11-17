package ChatGPT.Knapsack.PromptOnly.T7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithEmptyArrays() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {};
        int[] values = {};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result);
    }

    @Test
    public void testKnapsackWithValidItems() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result); // The optimal solution is to take items with weights 2 and 5.
    }

    @Test
    public void testKnapsackWithZeroCapacity() {
        Knapsack knapsack = new Knapsack();
        int capacity = 0;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result); // With zero capacity, the result should always be zero.
    }
}
