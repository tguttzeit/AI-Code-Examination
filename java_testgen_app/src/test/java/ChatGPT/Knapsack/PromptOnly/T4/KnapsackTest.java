package ChatGPT.Knapsack.PromptOnly.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testBottomUpWithExampleValues() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int expected = 7; // Maximum value expected for this scenario
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testBottomUpWithEmptyKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {};
        int[] values = {};
        int capacity = 10;
        int expected = 0; // The knapsack is empty, so the maximum value should be 0
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testBottomUpWithZeroCapacity() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4};
        int[] values = {5, 6, 7};
        int capacity = 0; // Zero capacity, so the maximum value should be 0
        int expected = 0;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }
}
