package ChatGPT.Knapsack.PromptOnly.T5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithEmptyInput() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {};
        int[] values = {};
        int capacity = 10;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result);
    }

    @Test
    public void testKnapsackWithOneItem() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2};
        int[] values = {10};
        int capacity = 5;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(10, result);
    }

    @Test
    public void testKnapsackWithMultipleItems() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {10, 20, 30, 40};
        int capacity = 7;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(70, result);
    }
}
