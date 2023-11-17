package ChatGPT.Knapsack.BookExampleCode.T6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        int weight1 = 5;
        int expected1 = 8; // Optimal: items 1 and 2
        int result1 = knapsack.bottomUp(weight1, weights1, values1);
        assertEquals(expected1, result1);

        // Test Case 2
        int[] weights2 = {1, 2, 3};
        int[] values2 = {6, 10, 12};
        int weight2 = 5;
        int expected2 = 22; // Optimal: items 2 and 3
        int result2 = knapsack.bottomUp(weight2, weights2, values2);
        assertEquals(expected2, result2);

        // Test Case 3
        int[] weights3 = {1, 3, 4, 5};
        int[] values3 = {1, 4, 5, 7};
        int weight3 = 7;
        int expected3 = 9; // Optimal: items 3 and 4
        int result3 = knapsack.bottomUp(weight3, weights3, values3);
        assertEquals(expected3, result3);
    }
}
