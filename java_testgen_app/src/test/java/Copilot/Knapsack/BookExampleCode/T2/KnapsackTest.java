package Copilot.Knapsack.BookExampleCode.T2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        assertEquals(220, knapsack.bottomUp(50, weights, values));
    }
}