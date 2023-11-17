package ChatGPT.Knapsack.AIGenerated.T10;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1: Basic case with small inputs
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        int capacity1 = 5;
        int expected1 = 7;
        int result1 = knapsack.bottomUp(capacity1, weights1, values1);
        assertEquals(expected1, result1);

        // Test Case 2: Empty knapsack (capacity = 0)
        int[] weights2 = {1, 2, 3};
        int[] values2 = {5, 7, 9};
        int capacity2 = 0;
        int expected2 = 0;
        int result2 = knapsack.bottomUp(capacity2, weights2, values2);
        assertEquals(expected2, result2);

        // Test Case 3: All items can be included
        int[] weights3 = {1, 2, 3};
        int[] values3 = {5, 7, 9};
        int capacity3 = 6;
        int expected3 = 14;
        int result3 = knapsack.bottomUp(capacity3, weights3, values3);
        assertEquals(expected3, result3);
    }
}
