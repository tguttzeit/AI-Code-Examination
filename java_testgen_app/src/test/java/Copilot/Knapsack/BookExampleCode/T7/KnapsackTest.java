package Copilot.Knapsack.BookExampleCode.T7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack k = new Knapsack();
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        assertEquals(220, k.bottomUp(50, weights, values));
    }
}