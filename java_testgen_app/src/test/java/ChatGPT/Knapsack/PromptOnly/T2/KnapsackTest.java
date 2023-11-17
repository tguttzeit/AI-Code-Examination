package ChatGPT.Knapsack.PromptOnly.T2;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testKnapsackWithEmptyArrays() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {};
        int[] values = {};
        int capacity = 10;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result);
    }

    @Test
    public void testKnapsackWithSingleItem() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2};
        int[] values = {3};
        int capacity = 1;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result);
    }

    @Test
    public void testKnapsackWithMultipleItems() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result);
    }
}
