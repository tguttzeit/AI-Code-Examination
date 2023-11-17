package Copilot.Knapsack.AIGenerated.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int capacity = 5;

        assertEquals(22, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testKnapsack2() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int capacity = 3;

        assertEquals(16, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testKnapsack3() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int capacity = 0;

        assertEquals(0, knapsack.bottomUp(capacity, weights, values));
    }
}