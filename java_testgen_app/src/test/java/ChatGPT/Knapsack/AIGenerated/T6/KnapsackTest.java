package ChatGPT.Knapsack.AIGenerated.T6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithEmptyInput() {
        Knapsack knapsack = new Knapsack();
        int capacity = 0;
        int[] weights = {};
        int[] values = {};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(0, result);
    }

    @Test
    public void testKnapsackWithSingleItem() {
        Knapsack knapsack = new Knapsack();
        int capacity = 5;
        int[] weights = {2};
        int[] values = {3};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(3, result);
    }

    @Test
    public void testKnapsackWithMultipleItems() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(10, result);
    }
}
