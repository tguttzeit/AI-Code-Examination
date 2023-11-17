package Copilot.Knapsack.AIGenerated.T7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    Knapsack knapsack = new Knapsack();
    int[] weights = { 2, 3, 4, 5 };
    int[] values = { 3, 4, 5, 6 };

    @Test
    public void testKnapsack() {
        assertEquals(7, knapsack.bottomUp(5, weights, values));
        assertEquals(8, knapsack.bottomUp(6, weights, values));
        assertEquals(9, knapsack.bottomUp(7, weights, values));
    }
}