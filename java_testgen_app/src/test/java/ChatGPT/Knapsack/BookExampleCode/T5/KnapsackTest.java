package ChatGPT.Knapsack.BookExampleCode.T5;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        // Test Case 1: Basic case with small values and weights
        int[] values1 = {60, 100, 120};
        int[] weights1 = {10, 20, 30};
        int weightCapacity1 = 50;
        int expected1 = 220;
        assertEquals(expected1, knapsack.bottomUp(weightCapacity1, weights1, values1));

        // Test Case 2: Larger values and weights
        int[] values2 = {10, 15, 40, 90, 75};
        int[] weights2 = {3, 7, 5, 9, 8};
        int weightCapacity2 = 20;
        int expected2 = 105;
        assertEquals(expected2, knapsack.bottomUp(weightCapacity2, weights2, values2));

        // Test Case 3: No items can be selected due to weight constraint
        int[] values3 = {30, 50, 60};
        int[] weights3 = {5, 8, 12};
        int weightCapacity3 = 3;
        int expected3 = 0;
        assertEquals(expected3, knapsack.bottomUp(weightCapacity3, weights3, values3));
    }
}
