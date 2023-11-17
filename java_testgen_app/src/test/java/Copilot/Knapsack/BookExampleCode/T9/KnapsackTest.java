package Copilot.Knapsack.BookExampleCode.T9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 1, 2, 4, 2, 5 };
        int[] values = { 5, 3, 5, 3, 2 };
        assertEquals(10, knapsack.bottomUp(10, weights, values));
    }

}