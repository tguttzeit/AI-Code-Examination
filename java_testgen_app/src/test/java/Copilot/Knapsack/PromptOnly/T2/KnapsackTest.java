package Copilot.Knapsack.PromptOnly.T2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class KnapsackTest {
    @Test
    public void testBottomUp() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 3 };
        int[] values = { 6, 10, 12 };
        assertEquals(22, knapsack.bottomUp(5, weights, values));
    }

    @Test
    public void testBottomUp2() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 3 };
        int[] values = { 6, 10, 12 };
        assertEquals(22, knapsack.bottomUp(5, weights, values));
    }

    @Test
    public void testBottomUp3() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 3 };
        int[] values = { 6, 10, 12 };
        assertEquals(22, knapsack.bottomUp(5, weights, values));
    }
}