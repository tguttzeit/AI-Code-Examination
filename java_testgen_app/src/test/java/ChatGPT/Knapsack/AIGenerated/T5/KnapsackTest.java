package ChatGPT.Knapsack.AIGenerated.T5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        int capacity1 = 5;
        int expected1 = 7; // Maximum value for capacity 5
        int result1 = knapsack.bottomUp(capacity1, weights1, values1);
        assertEquals(expected1, result1);

        // Test Case 2
        int[] weights2 = {1, 3, 4, 5};
        int[] values2 = {1, 4, 5, 7};
        int capacity2 = 7;
        int expected2 = 9; // Maximum value for capacity 7
        int result2 = knapsack.bottomUp(capacity2, weights2, values2);
        assertEquals(expected2, result2);

        // Test Case 3
        int[] weights3 = {3, 4, 5};
        int[] values3 = {4, 5, 6};
        int capacity3 = 2;
        int expected3 = 0; // No items can be selected within capacity 2
        int result3 = knapsack.bottomUp(capacity3, weights3, values3);
        assertEquals(expected3, result3);
    }
}
