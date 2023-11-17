package Copilot.Knapsack.PromptOnly.T7;

import static org.junit.Assert.*;


import org.junit.Test;

public class KnapsackTest {
    // Test 1
    @Test
    public void testBottomUp1() {
        int[] values = {1, 2, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 8;
        int result = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(8, result);
    }

    // Test 2
    @Test
    public void testBottomUp2() {
        int[] values = {1, 2, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 4;
        int result = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(3, result);
    }

    // Test 3
    @Test
    public void testBottomUp3() {
        int[] values = {1, 2, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 10;
        int result = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(11, result);
    }
}