package ChatGPT.Knapsack.BookExampleCode.T1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1: Small knapsack with one item
        int[] weights1 = {2};
        int[] values1 = {3};
        int weight1 = 1;
        int expected1 = 0;
        int result1 = knapsack.bottomUp(weight1, weights1, values1);
        assertEquals(expected1, result1);

        // Test Case 2: Larger knapsack with multiple items
        int[] weights2 = {2, 3, 4, 5};
        int[] values2 = {3, 4, 5, 6};
        int weight2 = 5;
        int expected2 = 8; // Max value is achieved with items {2, 3}
        int result2 = knapsack.bottomUp(weight2, weights2, values2);
        assertEquals(expected2, result2);

        // Test Case 3: Knapsack with no items
        int[] weights3 = {};
        int[] values3 = {};
        int weight3 = 10;
        int expected3 = 0; // No items, so no value can be obtained
        int result3 = knapsack.bottomUp(weight3, weights3, values3);
        assertEquals(expected3, result3);
    }
}
