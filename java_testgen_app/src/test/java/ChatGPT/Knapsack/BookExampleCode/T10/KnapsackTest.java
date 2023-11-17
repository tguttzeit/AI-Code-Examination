package ChatGPT.Knapsack.BookExampleCode.T10;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackWithExampleCase() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 5;
        int expected = 8; // The expected result for this case
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithEmptyItems() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {};
        int[] values = {};
        int weight = 10;
        int expected = 0; // No items to choose from, so the result should be 0
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackWithNoFitItems() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {7, 8, 9};
        int[] values = {5, 6, 7};
        int weight = 3;
        int expected = 0; // No item can fit in the knapsack, so the result should be 0
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
