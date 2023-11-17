package Copilot.Knapsack.PromptOnly.T4;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackTest {
    @Test
    public void testBottomUp() {
        // Test 1
        int[] weights = { 1, 3, 5, 7, 9, 11 };
        int[] values = { 2, 4, 6, 8, 10, 12 };
        int capacity = 0;
        int result = new Knapsack().bottomUp(capacity, weights, values);
        assertEquals(0, result);

        // Test 2
        capacity = 1;
        result = new Knapsack().bottomUp(capacity, weights, values);
        assertEquals(2, result);

        // Test 3
        capacity = 5;
        result = new Knapsack().bottomUp(capacity, weights, values);
        assertEquals(6, result);
    }
}