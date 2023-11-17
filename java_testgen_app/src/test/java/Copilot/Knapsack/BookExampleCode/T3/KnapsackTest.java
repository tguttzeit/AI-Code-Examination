package Copilot.Knapsack.BookExampleCode.T3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int weight = 50;
        assertEquals(220, knapsack.bottomUp(weight, weights, values));

        int[] values2 = { 1, 4, 5, 7 };
        int[] weights2 = { 1, 3, 4, 5 };
        int weight2 = 7;
        assertEquals(9, knapsack.bottomUp(weight2, weights2, values2));

        int[] values3 = { 10, 40, 30, 50 };
        int[] weights3 = { 5, 4, 6, 3 };
        int weight3 = 10;
        assertEquals(90, knapsack.bottomUp(weight3, weights3, values3));
    }
}