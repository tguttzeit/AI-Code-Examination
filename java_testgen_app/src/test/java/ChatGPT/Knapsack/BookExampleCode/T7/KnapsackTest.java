package ChatGPT.Knapsack.BookExampleCode.T7;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithEmptyItems() {
        Knapsack knapsack = new Knapsack();
        int weight = 10;
        int[] weights = {};
        int[] values = {};
        int expected = 0;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithSingleItemFit() {
        Knapsack knapsack = new Knapsack();
        int weight = 5;
        int[] weights = {2};
        int[] values = {3};
        int expected = 3;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithMultipleItems() {
        Knapsack knapsack = new Knapsack();
        int weight = 7;
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int expected = 7;
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
