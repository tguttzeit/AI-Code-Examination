package ChatGPT.Knapsack.BookExampleCode.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithZeroWeight() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 0;
        int expected = 0;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithValidWeight() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 5; // Knapsack can hold weight 5
        int expected = 7; // Max value = 4 + 3 = 7
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithLargeWeight() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 10; // Knapsack can hold weight 10
        int expected = 11; // Max value = 6 + 5 = 11
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
