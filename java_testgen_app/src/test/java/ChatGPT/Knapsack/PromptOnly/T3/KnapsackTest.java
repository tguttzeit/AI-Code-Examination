package ChatGPT.Knapsack.PromptOnly.T3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack1() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int expected = 7; // Maximum value for the given capacity

        int result = knapsack.bottomUp(capacity, weights, values);

        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack2() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {5, 4, 3, 2, 1};
        int capacity = 10;
        int expected = 14; // Maximum value for the given capacity

        int result = knapsack.bottomUp(capacity, weights, values);

        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack3() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {3, 5, 7, 8};
        int[] values = {4, 5, 10, 11};
        int capacity = 12;
        int expected = 20; // Maximum value for the given capacity

        int result = knapsack.bottomUp(capacity, weights, values);

        assertEquals(expected, result);
    }
}
