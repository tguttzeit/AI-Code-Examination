package ChatGPT.Knapsack.AIGenerated.T1;

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
    public void testKnapsackWithBasicInput() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result);
    }

    @Test
    public void testKnapsackWithLargeCapacity() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {5, 4, 3, 2, 1};
        int capacity = 20;
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(15, result);
    }
}
