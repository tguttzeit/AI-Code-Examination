package ChatGPT.Knapsack.BookExampleCode.T9;

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
    public void testKnapsackWithSmallCapacity() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 5;
        int expected = 7;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithLargeCapacity() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 10;
        int expected = 13;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
