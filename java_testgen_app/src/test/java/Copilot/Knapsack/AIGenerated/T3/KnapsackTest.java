package Copilot.Knapsack.AIGenerated.T3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();

        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int capacity = 7;

        assertEquals(9, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testKnapsack2() {
        Knapsack knapsack = new Knapsack();

        int[] weights = { 1, 2, 3, 4 };
        int[] values = { 1, 4, 5, 7 };
        int capacity = 5;

        assertEquals(9, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testKnapsack3() {
        Knapsack knapsack = new Knapsack();

        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int capacity = 6;

        assertEquals(8, knapsack.bottomUp(capacity, weights, values));
    }
}