package Copilot.Knapsack.AIGenerated.T2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class KnapsackTest {
    @Test
    public void testBottomUp() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 3, 4, 5 };
        int[] values = { 2, 3, 4, 5, 6 };

        assertEquals(7, knapsack.bottomUp(5, weights, values));
        assertEquals(0, knapsack.bottomUp(0, weights, values));
        assertEquals(0, knapsack.bottomUp(1, weights, values));
        assertEquals(6, knapsack.bottomUp(4, weights, values));
    }
}