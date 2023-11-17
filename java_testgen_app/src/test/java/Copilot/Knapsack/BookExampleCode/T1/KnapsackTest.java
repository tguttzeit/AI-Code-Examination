package Copilot.Knapsack.BookExampleCode.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 3 };
        int[] values = { 6, 10, 12 };
        int weight = 5;
        assertEquals(22, knapsack.bottomUp(weight, weights, values));
        weights = new int[] { 1, 2, 3, 4, 5 };
        values = new int[] { 6, 10, 12, 14, 15 };
        weight = 10;
        assertEquals(34, knapsack.bottomUp(weight, weights, values));
        weights = new int[] { 1, 2, 3, 4, 5 };
        values = new int[] { 6, 10, 12, 14, 15 };
        weight = 20;
        assertEquals(67, knapsack.bottomUp(weight, weights, values));
    }
}