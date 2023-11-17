package ChatGPT.Knapsack.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1: Basic test case with small values and weights
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        int weightCapacity1 = 5;
        int expected1 = 7; // Expected maximum value
        int result1 = knapsack.bottomUp(weightCapacity1, weights1, values1);
        assertEquals(expected1, result1);

        // Test Case 2: Test case with a larger weight capacity
        int[] weights2 = {1, 3, 4, 5};
        int[] values2 = {1, 4, 5, 7};
        int weightCapacity2 = 7;
        int expected2 = 9; // Expected maximum value
        int result2 = knapsack.bottomUp(weightCapacity2, weights2, values2);
        assertEquals(expected2, result2);

        // Test Case 3: Test case with no items
        int[] weights3 = {};
        int[] values3 = {};
        int weightCapacity3 = 10;
        int expected3 = 0; // Expected maximum value (no items to choose from)
        int result3 = knapsack.bottomUp(weightCapacity3, weights3, values3);
        assertEquals(expected3, result3);
    }
}
