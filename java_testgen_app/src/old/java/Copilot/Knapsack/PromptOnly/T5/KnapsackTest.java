package Copilot.Knapsack.PromptOnly.T5;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackTest {

    @Test
    public void testBottomUp() {
        int[] weights = { 2, 1, 3, 2 };
        int[] values = { 12, 10, 20, 15 };
        int capacity = 5;
        assertEquals(37, Knapsack.bottomUp(capacity, weights, values));
    }

}