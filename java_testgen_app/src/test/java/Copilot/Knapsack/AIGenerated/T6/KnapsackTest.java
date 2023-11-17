package Copilot.Knapsack.AIGenerated.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testBottomUp() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        int capacity = 5;
        assertEquals(7, knapsack.bottomUp(capacity, weights, values));
    }
}